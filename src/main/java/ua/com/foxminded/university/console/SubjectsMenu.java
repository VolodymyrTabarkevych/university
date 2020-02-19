package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;

class SubjectsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public SubjectsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showSubjectsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c")) {
                if (selectedOption.equals("a")) {
                    do {
                        String subjectName = reader.readLine();
                        // university.addNewSubject(subjectName);
                        System.out.println(CONTINUE_ADDING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        String subjectName = reader.readLine();
                        // university.removeSubject(subjectName);
                        System.out.println(CONTINUE_REMOVING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else {
                    // viewer.viewAllSubjects();
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }
}
