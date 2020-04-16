package ua.com.foxminded.university.console;

import java.io.BufferedReader;

import javax.sql.DataSource;

public class UniversityMenu extends TextUniversityMenu {
    private StudentsMenu studentsMenu;
    private SubjectsMenu subjectsMenu;
    private RoomsMenu roomsMenu;
    private GroupsMenu groupsMenu;
    private TeachersMenu teachersMenu;

    public UniversityMenu(DataSource dataSource) {
        this.studentsMenu = new StudentsMenu(dataSource);
        this.subjectsMenu = new SubjectsMenu(dataSource);
        this.roomsMenu = new RoomsMenu(dataSource);
        this.groupsMenu = new GroupsMenu(dataSource);
        this.teachersMenu = new TeachersMenu(dataSource);
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
