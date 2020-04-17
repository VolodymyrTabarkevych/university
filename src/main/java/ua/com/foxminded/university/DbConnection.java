package ua.com.foxminded.university;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;

@Getter
@Configuration
@ComponentScan("ua.com.foxminded.university")
@PropertySource("classpath:database.properties")
public class DbConnection {
    
    @Bean("dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/university");
        dataSource.setUsername("manager");
        dataSource.setPassword("1111");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
