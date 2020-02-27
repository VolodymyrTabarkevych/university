package ua.com.foxminded.university;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

import ua.com.foxminded.university.DbConnection;

public class UniversityDatabase {
    private DbConnection dbConnection;
    private DataSource dataSource;

    public UniversityDatabase(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DataSource createDatabase() {
        try (BufferedReader sqlFile = new BufferedReader(new FileReader("src/main/resources/scheme.sql"));
                Statement statement = dbConnection.init().getConnection().createStatement();
                Scanner scan = new Scanner(sqlFile)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                statement.executeUpdate(line);
            }
            createTablesForDatabase();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return dataSource;
    }

    private void createTablesForDatabase() {
        dataSource = dbConnection.initUniversityDatabase();
        try (BufferedReader sqlFile = new BufferedReader(new FileReader("src/main/resources/scheme.tables.sql"));
                Statement statement = dataSource.getConnection().createStatement();
                Scanner scan = new Scanner(sqlFile)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                statement.executeUpdate(line);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
