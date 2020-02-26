package ua.com.foxminded.university;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.DbConnection;

public class UniversityDatabase {
    private static final String user = "admin";
    private static final String password = "1111";
    private static final String dbName = "university";
    private DbConnection dbConnection;
    private DataSource dataSource;

    public UniversityDatabase(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DbConnection createDatabase() {
        dataSource = dbConnection.init();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            try {
                statement.executeUpdate("DROP DATABASE IF EXISTS " + dbName);
                statement.executeUpdate("CREATE DATABASE " + dbName);
            } catch (SQLException e) {
                System.out.println("Database is already exists!");
            }
            try {
                statement.executeUpdate("DROP USER IF EXISTS " + user);
                statement.executeUpdate("CREATE USER " + user + " WITH PASSWORD " + "'" + password + "'");
            } catch (SQLException e) {
                System.out.println("User '" + user + "' is already exists!");
            }
            statement.executeUpdate("GRANT ALL PRIVILEGES ON DATABASE " + dbName + " to " + user);
            dbConnection.setProps("url", dbConnection.getProps().getProperty("url") + "university");
            dbConnection.setProps("user", user);
            dbConnection.setProps("password", password);
            statement.executeUpdate("DROP TABLE IF EXISTS lectures CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS students CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS groups CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS rooms CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS teacherssubjects CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS teachers CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS subjects CASCADE");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dbConnection;
    }
}
