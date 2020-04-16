package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import javax.sql.DataSource;

import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.service.SubjectService;

class SubjectsMenu extends TextUniversityMenu {
    private SubjectService subjectService;
    private int rowsAffected = 0;
    private String selectedOption = "";

    public SubjectsMenu(DataSource dataSource) {
        this.subjectService = new SubjectService(dataSource);
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
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void addSubject(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter subject name: ");
            String subjectName = reader.readLine();
            rowsAffected = subjectService.addSubject(new Subject(subjectName));
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_ADDED);
            } else {
                System.err.println(DATA_HASNT_BEEN_ADDED);
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeSubject(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter subject id: ");
            int subjectId = Integer.parseInt(reader.readLine());
            rowsAffected = subjectService.removeSubject(subjectId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.err.println(DATA_HASNT_BEEN_DELETED);
            }
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllSubjects() {
        for (Subject subject : subjectService.viewAllSubjects()) {
            System.out.println(subject.toString());
        }
    }
}
