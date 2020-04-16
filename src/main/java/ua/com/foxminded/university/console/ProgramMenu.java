package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import ua.com.foxminded.university.DbConnection;

public class ProgramMenu extends TextUniversityMenu {
    private DbConnection dbConnection;
    private DataSource dataSource;
    private UniversityMenu universityMenu;
    private TimetableMenu timetableMenu;

    public ProgramMenu() {
        this.dbConnection = new DbConnection();
        this.dataSource = dbConnection.init();
        this.universityMenu = new UniversityMenu(this.dataSource);
        this.timetableMenu = new TimetableMenu(this.dataSource);
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
