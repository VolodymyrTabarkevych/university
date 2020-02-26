package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Subject;

class SubjectsMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private String selectedOption = "";

    public SubjectsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showSubjectsMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                addSubject(reader);
                break;
            case "b":
                removeSubject(reader);
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
        do {
            System.out.println("Enter subject name: ");
            String subjectName = reader.readLine();
            dbCooperator.getSubjectDao().save(new Subject(subjectName));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeSubject(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter subject id: ");
            int subjectId = Integer.parseInt(reader.readLine());
            dbCooperator.getSubjectDao().delete(subjectId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllSubjects() {
        for (Subject subject : dbCooperator.getSubjectDao().findAll()) {
            System.out.println(subject.toString());
        }
    }
}
