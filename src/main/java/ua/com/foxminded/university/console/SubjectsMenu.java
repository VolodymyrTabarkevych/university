package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.service.SubjectService;

@Component
class SubjectsMenu extends TextUniversityMenu {
    private static final Logger logger = LoggerFactory.getLogger(SubjectsMenu.class);
    private SubjectService subjectService;
    private String selectedOption = "";

    @Autowired
    public SubjectsMenu(SubjectService subjectService) {
        this.subjectService = subjectService;
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
        } catch (IOException | NumberFormatException | EntityNameExistsException e) {
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void addSubject(BufferedReader reader) throws IOException, EntityNameExistsException {
        do {
            System.out.println("Enter subject name: ");
            String subjectName = reader.readLine();
            subjectService.addSubject(new Subject(subjectName));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeSubject(BufferedReader reader) throws IOException, NumberFormatException {
        do {
            System.out.println("Enter subject id: ");
            int subjectId = Integer.parseInt(reader.readLine());
            subjectService.removeSubject(subjectId);
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
