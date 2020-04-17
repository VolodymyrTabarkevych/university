package ua.com.foxminded.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:database.properties")
public class DbConnection {
    @Autowired
    private Environment enviroment;

    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(enviroment.getProperty("url"));
        dataSource.setUsername(enviroment.getProperty("user"));
        dataSource.setPassword(enviroment.getProperty("password"));
        dataSource.setDriverClassName(enviroment.getProperty("driver"));
        return dataSource;
    }
}
