package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Teacher;

public class TeachersMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private String selectedOption = "";

    public TeachersMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
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
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addTeacher(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            dbCooperator.getTeacherDaoJdbcTemplateImpl().save(new Teacher(firstName, lastName));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeTeacher(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter teacher id: ");
            int teacherId = Integer.parseInt(reader.readLine());
            dbCooperator.getTeacherDaoJdbcTemplateImpl().delete(teacherId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    public void viewAllTeachers() {
        for (Teacher teacher : dbCooperator.getTeacherDaoJdbcTemplateImpl().findAll()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
    }
}
