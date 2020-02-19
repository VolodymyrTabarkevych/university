package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

class StudentsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public StudentsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showStudentsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                do {
                    addStudent(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "b":
                do {
                    removeStudent(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "c":
                changeStudentGroup(reader);
                break;
            case "d":
                viewAllStudents();
                break;
            default:
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addStudent(BufferedReader reader) throws IOException {
        System.out.println("Enter first name: ");
        String firstName = reader.readLine();
        System.out.println("Enter last name: ");
        String lastName = reader.readLine();
        System.out.println("Groups: ");
        for (Group group : dbCooperator.getGroupDaoJdbcTemplateImpl().findAll()) {
            System.out.println("Group id: " + group.getId() + " Group name: " + group.getName());
        }
        System.out.println("Enter group id: ");
        int groupId = Integer.parseInt(reader.readLine());
        try {
            dbCooperator.getStudentDaoJdbcTemplateImpl().save(new Student(firstName, lastName, new Group(groupId)));
        } catch (DataIntegrityViolationException e) {
            System.out.println("No group with such id!");
        }
        System.out.println(CONTINUE_ADDING);
    }

    private void removeStudent(BufferedReader reader) throws NumberFormatException, IOException {
        System.out.println("Enter student id: ");
        int studentId = Integer.parseInt(reader.readLine());
        dbCooperator.getStudentDaoJdbcTemplateImpl().delete(studentId);
        System.out.println(CONTINUE_REMOVING);
    }

    private void changeStudentGroup(BufferedReader reader) throws NumberFormatException, IOException {
        System.out.println("Enter student id: ");
        int studentId = Integer.parseInt(reader.readLine());
        System.out.println("Enter group id: ");
        int groupId = Integer.parseInt(reader.readLine());
        Student student = dbCooperator.getStudentDaoJdbcTemplateImpl().find(studentId);
        student.setGroup(new Group(groupId));
        dbCooperator.getStudentDaoJdbcTemplateImpl().update(student);
    }

    private void viewAllStudents() {
        for (Student student : dbCooperator.getStudentDaoJdbcTemplateImpl().findAll()) {
            System.out.println(student.getId() + ". " + student.getFirstName() + " " + student.getLastName());
        }
    }
}
