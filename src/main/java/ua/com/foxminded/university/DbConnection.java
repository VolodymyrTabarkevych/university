package ua.com.foxminded.university;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;

@Getter
public class DbConnection {
    private Properties props;

    public DbConnection() {
        props = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")) {
            props.load(in);
        } catch (IOException e) {
            System.out.println("Cannot read the file: " + e.getStackTrace());
        }
    }

    public DriverManagerDataSource init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(props.getProperty("user"));
        dataSource.setPassword(props.getProperty("password"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    public DriverManagerDataSource initUniversityDatabase() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(props.getProperty("university.user"));
        dataSource.setPassword(props.getProperty("university.password"));
        dataSource.setUrl(props.getProperty("university.url"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
