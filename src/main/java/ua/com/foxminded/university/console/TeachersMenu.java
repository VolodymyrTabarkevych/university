package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.models.Teacher;
import ua.com.foxminded.university.service.TeacherService;

@Component
public class TeachersMenu extends MenuText {
    private static final Logger logger = LoggerFactory.getLogger(TeachersMenu.class);
    @Autowired
    private TeacherService teacherService;
    private String selectedOption = "";

    public void start(BufferedReader reader) {
        showTeachersMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
                case "p":
                    break;
                case "a":
                    addTeacher(reader);
                    break;
                case "b":
                    removeTeacher(reader);
                    break;
                case "c":
                    addSubjectToTeacher(reader);
                    break;
                case "d":
                    viewAllTeacherSubjects(reader);
                    break;
                case "e":
                    viewAllTeachers();
                    break;
                default:
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException | NumberFormatException | EntityNameExistsException e) {
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void addTeacher(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            teacherService.addTeacher(Teacher.builder().firstName(firstName).lastName(lastName).build());
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeTeacher(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter teacher id: ");
            int teacherId = Integer.parseInt(reader.readLine());
            teacherService.removeTeacher(teacherId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void addSubjectToTeacher(BufferedReader reader) throws IOException, NumberFormatException {
        do {
            System.out.println("Enter teacher id: ");
            int teacherId = Integer.parseInt(reader.readLine());
            System.out.println("Enter subject id: ");
            int subjectId = Integer.parseInt(reader.readLine());
            teacherService.addSubjectToTeacher(teacherId, subjectId);
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllTeacherSubjects(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter teacher id: ");
        int teacherId = Integer.parseInt(reader.readLine());
        for (Subject subject : teacherService.viewAllTeacherSubject(teacherId)) {
            System.out.println(subject.toString());
        }
    }

    private void viewAllTeachers() {
        for (Teacher teacher : teacherService.viewAllTeachers()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
    }
}
