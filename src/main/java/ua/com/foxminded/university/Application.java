package ua.com.foxminded.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ua.com.foxminded.university.console.ProgramMenu;

@SpringBootApplication
@ComponentScan(basePackages = "ua.com.foxminded.university")
@EnableJpaRepositories(basePackages = "ua.com.foxminded.university.repositories")
@EntityScan(basePackages = "ua.com.foxminded.university.models")
public class Application implements CommandLineRunner {
    @Autowired
    private ProgramMenu programMenu;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.NONE).run();
    }

    @Override
    public void run(String... args) {
        programMenu.run();
    }

}
