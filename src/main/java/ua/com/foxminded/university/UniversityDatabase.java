package ua.com.foxminded.university;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.DbConnection;

public class UniversityDatabase {
    private DbConnection dbConnection;
    private DataSource dataSource;

    public UniversityDatabase(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DbConnection createDatabase() {
        dataSource = dbConnection.init();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            try {
                statement.executeUpdate("DROP DATABASE IF EXISTS university");
                statement.executeUpdate("CREATE DATABASE university");
            } catch (SQLException e) {
                System.out.println("Database is already exists!");
            }
            try {
                statement.executeUpdate("DROP USER IF EXISTS admin");
                statement.executeUpdate("CREATE USER admin WITH PASSWORD '1111'");
            } catch (SQLException e) {
                System.out.println("User 'admin' is already exists!");
            }
            statement.executeUpdate("GRANT ALL PRIVILEGES ON DATABASE university to admin");
            dbConnection.setProps("url", dbConnection.getProps().getProperty("url") + "university");
            dbConnection.setProps("user", "admin");
            dbConnection.setProps("password", "1111");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dbConnection;
    }

    public void createDataForDatabase() {
        dataSource = dbConnection.init();
        try (BufferedReader sqlFile = new BufferedReader(new FileReader("src/main/resources/database.sql"));
                Statement statement = dataSource.getConnection().createStatement();
                Scanner scan = new Scanner(sqlFile)) {
            statement.executeUpdate("DROP TABLE IF EXISTS lectures CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS students CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS groups CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS rooms CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS teacherssubjects CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS teachers CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS subjects CASCADE");
            String line = "";
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                statement.executeUpdate(line);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Cant create data for database!");
        }
    }
}
