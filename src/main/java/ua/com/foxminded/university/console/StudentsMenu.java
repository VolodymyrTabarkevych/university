package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ua.com.foxminded.university.domain.Student;
import ua.com.foxminded.university.service.StudentService;

@Component
class StudentsMenu extends TextUniversityMenu {
    private static final Logger logger = LoggerFactory.getLogger(StudentsMenu.class);
    private StudentService studentService;
    private String selectedOption = "";

    @Autowired
    public StudentsMenu(StudentService studentService) {
        this.studentService = studentService;
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
        } catch (IOException | NumberFormatException | DataIntegrityViolationException e) {
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void addStudent(BufferedReader reader)
            throws IOException, DataIntegrityViolationException, NumberFormatException {
        do {
            System.out.println("Enter first name: ");
            String firstName = reader.readLine();
            System.out.println("Enter last name: ");
            String lastName = reader.readLine();
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            studentService.addStudent(new Student(firstName, lastName), groupId);
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeStudent(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            studentService.removeStudent(studentId);
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
            studentService.changeStudentGroup(studentId, groupId);
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
