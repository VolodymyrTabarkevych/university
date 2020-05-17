package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Group;
import ua.com.foxminded.university.models.Student;
import ua.com.foxminded.university.service.GroupService;

@Component
public class GroupsMenu extends MenuText {
    private static final Logger logger = LoggerFactory.getLogger(GroupsMenu.class);
    @Autowired
    private GroupService groupService;
    private String selectedOption = "";

    public void start(BufferedReader reader) {
        showGroupsMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
                case "p":
                    break;
                case "a":
                    addGroup(reader);
                    break;
                case "b":
                    removeGroup(reader);
                    break;
                case "c":
                    addStudentToGroup(reader);
                    break;
                case "d":
                    viewAllGroups();
                    break;
                case "e":
                    viewAllStudentsInGroup(reader);
                    break;
                default:
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException | NullPointerException | IndexOutOfBoundsException | EntityNameExistsException e) {
            logger.error(e.getMessage());
            System.out.println(e);
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void addGroup(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter group name: ");
            String groupName = reader.readLine();
            groupService.addGroup(Group.builder().name(groupName).build());
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeGroup(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            groupService.removeGroup(groupId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void addStudentToGroup(BufferedReader reader) throws IOException, NullPointerException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            groupService.addStudentToGroup(groupId, studentId);
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllGroups() {
        for (Group group : groupService.viewAllGroups()) {
            System.out.println(group.getName());
        }
    }

    private void viewAllStudentsInGroup(BufferedReader reader) throws IOException, IndexOutOfBoundsException {
        System.out.println("Enter group id: ");
        int groupId = Integer.parseInt(reader.readLine());
        Set<Student> students = new HashSet<>();
        students = groupService.viewAllStudentsInGroup(groupId);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
