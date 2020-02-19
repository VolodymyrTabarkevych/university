package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Subject;

class SubjectsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public SubjectsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showSubjectsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                do {
                    addSubject(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "b":
                do {
                    removeSubject(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "c":
                viewAllSubjects();
                break;
            default:
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addSubject(BufferedReader reader) throws IOException {
        String subjectName = reader.readLine();
        // university.addNewSubject(subjectName);
        System.out.println(CONTINUE_ADDING);

    }

    private void removeSubject(BufferedReader reader) throws IOException {
        String subjectName = reader.readLine();
        // university.removeSubject(subjectName);
        System.out.println(CONTINUE_REMOVING);
    }

    private void viewAllSubjects() {
        for (Subject subject : dbCooperator.getSubjectDaoJdbcTemplateImpl().findAll()) {
            System.out.println(subject.getName());
        }
    }
}
