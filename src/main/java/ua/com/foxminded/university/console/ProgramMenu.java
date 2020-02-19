package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;

public class ProgramMenu extends TextUniversityMenu {
    DbConnection dbConnection = new DbConnection();
    DbCooperator dbCooperator = new DbCooperator(dbConnection.init());
    UniversityMenu universityMenu = new UniversityMenu(dbCooperator);
    TimetableMenu timetableMenu = new TimetableMenu();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = " ";

        while (!selectedOption.equals("")) {
            showOptions();
            try {
                selectedOption = reader.readLine();
                if (selectedOption.equals("a") || selectedOption.equals("b")) {
                    if (selectedOption.equals("a")) {
                        showTimetableMenuOptions();
                        selectedOption = reader.readLine();
                        // timetableMenu.start(selectedOption, reader);
                    } else {
                        showUniversityMenuOptions();
                        selectedOption = reader.readLine();
                        universityMenu.start(selectedOption, reader);
                    }
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(WRONG_INPUT);
            }
        }
    }
}
