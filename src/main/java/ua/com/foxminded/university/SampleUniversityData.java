package ua.com.foxminded.university;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

public class SampleUniversityData {
    private DataSource dataSource;

    public SampleUniversityData(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createData() {
        try (BufferedReader sqlFile = new BufferedReader(new FileReader("src/main/resources/database.sql"));
                Statement statement = dataSource.getConnection().createStatement();
                Scanner scan = new Scanner(sqlFile)) {
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
