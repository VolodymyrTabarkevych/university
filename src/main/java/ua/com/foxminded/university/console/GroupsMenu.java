package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;

public class GroupsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public GroupsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showGroupsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c") || selectedOption.equals("d")
                    || selectedOption.equals("e")) {
                if (selectedOption.equals("a")) {
                    do {
                        System.out.println("Enter group name: ");
                        String groupName = reader.readLine();
                        // university.addNewGroup(groupName);
                        System.out.println(CONTINUE_ADDING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        System.out.println("Enter group name: ");
                        String groupName = reader.readLine();
                        // university.removeGroup(groupName);
                        System.out.println(CONTINUE_REMOVING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("c")) {
                    do {
                        System.out.println("Enter student id: ");
                        int studentId = Integer.parseInt(reader.readLine());
                        System.out.println("Enter group name: ");
                        String groupName = reader.readLine();
                        // university.changeStudentGroup(studentId, groupName);
                        System.out.println(CONTINUE_CHANGING);
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("d")) {
                    // viewer.viewAllGroups();
                } else if (selectedOption.equals("e")) {
                    do {
                        System.out.println("Enter group name: ");
                        String groupName = reader.readLine();
                        // viewer.showAllStudents(finder.findGroupByName(groupName));
                        System.out.println(CONTINUE_CHANGING);
                    } while (!selectedOption.equals(""));
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }
}
