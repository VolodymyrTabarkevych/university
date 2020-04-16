package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import ua.com.foxminded.universit.service.StudentService;
import ua.com.foxminded.university.domain.Student;

class StudentsMenu extends TextUniversityMenu {
    private StudentService studentService;
    private int rowsAffected = 0;
    private String selectedOption = "";

    public StudentsMenu(DataSource dataSource) {
        this.studentService = new StudentService(dataSource);
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
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void addStudent(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            try {
                rowsAffected = studentService.addStudent(new Student(firstName, lastName), groupId);
                if (rowsAffected > 0) {
                    System.out.println(DATA_HAS_BEEN_ADDED);
                } else {
                    System.err.println(DATA_HASNT_BEEN_ADDED);
                }
            } catch (DataIntegrityViolationException e) {
                System.err.println("No group with such id!");
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeStudent(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            rowsAffected = studentService.removeStudent(studentId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.err.println(DATA_HASNT_BEEN_DELETED);
            }
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
            rowsAffected = studentService.changeStudentGroup(studentId, groupId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllStudents() {
        for (Student student : studentService.viewAllStudents()) {
            System.out.println(student.getId() + ". " + student.getFirstName() + " " + student.getLastName());
        }
    }
}
