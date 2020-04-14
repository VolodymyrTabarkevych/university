package ua.com.foxminded.university.console;

import java.io.BufferedReader;

import ua.com.foxminded.university.DbCooperator;

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
        switch (selectedOption) {
            case "p":
                break;
            case "a":
                teachersMenu.start(reader);
                break;
            case "b":
                studentsMenu.start(reader);
                break;
            case "c":
                groupsMenu.start(reader);
                break;
            case "d":
                roomsMenu.start(reader);
                break;
            case "e":
                subjectsMenu.start(reader);
                break;
            default:
                System.err.println(WRONG_INPUT);
        }
    }
}
