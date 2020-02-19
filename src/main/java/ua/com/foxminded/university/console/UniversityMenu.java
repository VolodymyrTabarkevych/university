package ua.com.foxminded.university.console;

import java.io.BufferedReader;

import ua.com.foxminded.university.dao.DbCooperator;

public class UniversityMenu extends TextUniversityMenu {
    private StudentsMenu studentsMenu;
    private SubjectsMenu subjectsMenu;
    private RoomsMenu roomsMenu;
    private GroupsMenu groupsMenu;
    private TeachersMenu teachersMenu;

    public UniversityMenu(DbCooperator dbCooperator) {
        this.studentsMenu = new StudentsMenu(dbCooperator);
        this.subjectsMenu = new SubjectsMenu(dbCooperator);
        this.roomsMenu = new RoomsMenu(dbCooperator);
        this.groupsMenu = new GroupsMenu(dbCooperator);
        this.teachersMenu = new TeachersMenu(dbCooperator);
    }

    public void start(String selectedOption, BufferedReader reader) {
        if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                || selectedOption.equals("b") || selectedOption.equals("c") || selectedOption.equals("d")
                || selectedOption.equals("e")) {
            if (selectedOption.equals("a")) {
                teachersMenu.start(reader);
            } else if (selectedOption.equals("b")) {
                studentsMenu.start(reader);
            } else if (selectedOption.equals("c")) {
                groupsMenu.start(reader);
            } else if (selectedOption.equals("d")) {
                roomsMenu.start(reader);
            } else if (selectedOption.equals("e")) {
                subjectsMenu.start(reader);
            } else {
                System.out.println(WRONG_INPUT);
            }
        }
    }
}
