package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import javax.sql.DataSource;

import ua.com.foxminded.universit.service.TeacherService;
import ua.com.foxminded.university.domain.Teacher;

public class TeachersMenu extends TextUniversityMenu {
    private TeacherService teacherService;
    private int rowsAffected = 0;
    private String selectedOption = "";

    public TeachersMenu(DataSource dataSource) {
        this.teacherService = new TeacherService(dataSource);
    }

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
                    viewAllTeachers();
                    break;
                default:
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void addTeacher(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            rowsAffected = teacherService.addTeacher(new Teacher(firstName, lastName));
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_ADDED);
            } else {
                System.err.println(DATA_HASNT_BEEN_ADDED);
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeTeacher(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter teacher id: ");
            int teacherId = Integer.parseInt(reader.readLine());
            rowsAffected = teacherService.removeTeacher(teacherId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.err.println(DATA_HASNT_BEEN_DELETED);
            }
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllTeachers() {
        for (Teacher teacher : teacherService.viewAllTeachers()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
    }
}
