package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.domain.Teacher;

public class TeachersMenu extends Menu {
    public void start(BufferedReader reader) {
        textMenu.showTeachersMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c")) {
                if (selectedOption.equals("a")) {
                    do {
                        addTeacher(reader);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        deleteTeacher(reader);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("c")) {
                    viewAllTeachers();
                }
            } else {
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addTeacher(BufferedReader reader) throws IOException {
        System.out.println("Enter first name: ");
        String firstName = reader.readLine();
        System.out.println("Enter last name: ");
        String lastName = reader.readLine();
        dbCooperator.getTeacherDaoJdbcTemplateImpl().save(new Teacher(firstName, lastName));
        System.out.println(CONTINUE_ADDING);
    }

    private void deleteTeacher(BufferedReader reader) throws NumberFormatException, IOException {
        System.out.println("Enter teacher id: ");
        int teacherId = Integer.parseInt(reader.readLine());
        dbCooperator.getTeacherDaoJdbcTemplateImpl().delete(teacherId);
        System.out.println(CONTINUE_REMOVING);
    }

    public void viewAllTeachers() {
        for (Teacher teacher : dbCooperator.getTeacherDaoJdbcTemplateImpl().findAll()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
    }
}
