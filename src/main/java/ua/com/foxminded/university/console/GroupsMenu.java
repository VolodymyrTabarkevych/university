package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Group;

public class GroupsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public GroupsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showGroupsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                do {
                    addGroup(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "b":
                do {
                    removeGroup(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "c":
                do {
                    addStudentToGroup(reader);
                } while (!selectedOption.equals(""));
                break;
            case "d":
                viewAllGroups();
                break;
            case "e":
                do {
                    viewAllStudentsInGroup(reader);
                } while (!selectedOption.equals(""));
                break;
            default:
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addGroup(BufferedReader reader) throws IOException {
        System.out.println("Enter group name: ");
        String groupName = reader.readLine();
        // university.addNewGroup(groupName);
        System.out.println(CONTINUE_ADDING);
    }

    private void removeGroup(BufferedReader reader) throws IOException {
        System.out.println("Enter group name: ");
        String groupName = reader.readLine();
        // university.removeGroup(groupName);
        System.out.println(CONTINUE_REMOVING);
    }

    private void addStudentToGroup(BufferedReader reader) throws IOException {
        System.out.println("Enter student id: ");
        int studentId = Integer.parseInt(reader.readLine());
        System.out.println("Enter group name: ");
        String groupName = reader.readLine();
        // university.changeStudentGroup(studentId, groupName);
        System.out.println(CONTINUE_CHANGING);
    }

    private void viewAllGroups() {
        for (Group group : dbCooperator.getGroupDaoJdbcTemplateImpl().findAll()) {
            System.out.println(group.getName());
        }
    }

    private void viewAllStudentsInGroup(BufferedReader reader) throws IOException {
        System.out.println("Enter group name: ");
        String groupName = reader.readLine();
        // viewer.showAllStudents(finder.findGroupByName(groupName));
        System.out.println(CONTINUE_CHANGING);
    }
}
