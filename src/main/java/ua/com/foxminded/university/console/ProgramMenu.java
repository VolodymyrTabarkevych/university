package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.com.foxminded.university.DbConnection;

public class ProgramMenu extends TextUniversityMenu {

    private UniversityMenu universityMenu;
    private TimetableMenu timetableMenu;
    private AnnotationConfigApplicationContext context;

    public ProgramMenu() {
        context = new AnnotationConfigApplicationContext(DbConnection.class);
        this.universityMenu = context.getBean("universityMenu", UniversityMenu.class);
        this.timetableMenu = context.getBean("timetableMenu", TimetableMenu.class);
    }

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = "";

        do {
            showOptions();
            try {
                selectedOption = reader.readLine();
                switch (selectedOption) {
                    case "":
                        break;
                    case "a":
                        showTimetableMenuOptions();
                        selectedOption = reader.readLine();
                        timetableMenu.start(selectedOption, reader);
                        break;
                    case "b":
                        showUniversityMenuOptions();
                        selectedOption = reader.readLine();
                        universityMenu.start(selectedOption, reader);
                        break;
                    default:
                        System.err.println(WRONG_INPUT);
                }
            } catch (NumberFormatException | IOException e) {
                System.err.println(WRONG_INPUT);
            }
        } while (!selectedOption.equals(""));
    }
}
