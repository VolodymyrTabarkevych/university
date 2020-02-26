package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.dao.DataIntegrityViolationException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

class StudentsMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private String selectedOption = "";

    public StudentsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showStudentsMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                addStudent(reader);
                break;
            case "b":
                removeStudent(reader);
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
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            System.out.println("Groups: ");
            for (Group group : dbCooperator.getGroupDao().findAll()) {
                System.out.println("Group id: " + group.getId() + " Group name: " + group.getName());
            }
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            try {
                dbCooperator.getStudentDao().save(new Student(firstName, lastName, new Group(groupId)));
            } catch (DataIntegrityViolationException e) {
                System.out.println("No group with such id!");
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeStudent(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            dbCooperator.getStudentDao().delete(studentId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeStudentGroup(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            Student student = dbCooperator.getStudentDao().find(studentId);
            student.setGroup(new Group(groupId));
            dbCooperator.getStudentDao().update(student);
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllStudents() {
        for (Student student : dbCooperator.getStudentDao().findAll()) {
            System.out.println(student.getId() + ". " + student.getFirstName() + " " + student.getLastName());
        }
    }
}
