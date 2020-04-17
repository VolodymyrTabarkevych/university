package ua.com.foxminded.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("ua.com.foxminded.university")
public class SpringConfig {
    private DbConnection dbConnection;

    @Autowired
    public SpringConfig(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        return dbConnection.driverManagerDataSource();
    }
}
