package ua.com.foxminded.university;

import java.io.IOException;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;

@Getter
public class DbConnection {
    private Properties props;

    public DbConnection() {
        props = new Properties();
        try {
            props.load(DbConnection.class.getResourceAsStream("/database.properties"));
        } catch (IOException | NullPointerException e) {
            System.err.println("Cannot load properies file! " + e.getMessage());
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
}
