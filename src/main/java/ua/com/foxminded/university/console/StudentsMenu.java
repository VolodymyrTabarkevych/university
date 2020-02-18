package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

public class StudentsMenu extends Menu {
    public void start(BufferedReader reader) {
        textMenu.showStudentsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c")) {
                if (selectedOption.equals("a")) {
                    do {
                        System.out.println("Enter first name: ");
                        String firstName = reader.readLine();
                        System.out.println("Enter last name: ");
                        String lastName = reader.readLine();
                        System.out.println("Enter group id: ");
                        int groupId = Integer.parseInt(reader.readLine());
                        dbCooperator.getStudentDaoJdbcTemplateImpl()
                                .save(new Student(firstName, lastName, new Group(groupId)));
                        System.out.println(CONTINUE_ADDING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        System.out.println("Enter student id: ");
                        int studentId = Integer.parseInt(reader.readLine());
                        dbCooperator.getStudentDaoJdbcTemplateImpl().delete(studentId);
                        System.out.println(CONTINUE_REMOVING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("c")) {
                    System.out.println("Enter student id: ");
                    int studentId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter group id: ");
                    int groupId = Integer.parseInt(reader.readLine());
                    Student student = dbCooperator.getStudentDaoJdbcTemplateImpl().find(studentId);
                    student.setGroup(new Group(groupId));
                    dbCooperator.getStudentDaoJdbcTemplateImpl().update(student);
                } else if (selectedOption.equals("d")) {
                    viewer.viewAllStudents();
                }
            } else {
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }
}
