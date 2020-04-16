package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import javax.sql.DataSource;

import ua.com.foxminded.universit.service.GroupService;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

public class GroupsMenu extends TextUniversityMenu {
    private GroupService groupService;
    private String selectedOption = "";
    private int rowsAffected = 0;

    public GroupsMenu(DataSource dataSource) {
        this.groupService = new GroupService(dataSource);
    }

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
        } catch (IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void addGroup(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter group name: ");
            String groupName = reader.readLine();
            rowsAffected = groupService.addGroup(new Group(groupName));
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_ADDED);
            } else {
                System.err.println(DATA_HASNT_BEEN_ADDED);
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeGroup(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            rowsAffected = groupService.removeGroup(groupId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.err.println(DATA_HASNT_BEEN_DELETED);
            }
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void addStudentToGroup(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter student id: ");
            int studentId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            int groupId = Integer.parseInt(reader.readLine());
            rowsAffected = groupService.addStudentToGroup(groupId, studentId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllGroups() {
        for (Group group : groupService.viewAllGroups()) {
            System.out.println(group.getName());
        }
    }

    private void viewAllStudentsInGroup(BufferedReader reader) throws IOException {
        System.out.println("Enter group id: ");
        int groupId = Integer.parseInt(reader.readLine());
        for (Student student : groupService.viewAllStudentsInGroup(groupId)) {
            System.out.println(student.toString());
        }
        System.out.println(CONTINUE_CHANGING);
    }
}
