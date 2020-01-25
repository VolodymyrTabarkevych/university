package ua.com.foxminded.university.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DbConnection {
    public DriverManagerDataSource init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/university");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
