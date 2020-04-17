package ua.com.foxminded.university.console;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityMenu extends TextUniversityMenu {
    private StudentsMenu studentsMenu;
    private SubjectsMenu subjectsMenu;
    private RoomsMenu roomsMenu;
    private GroupsMenu groupsMenu;
    private TeachersMenu teachersMenu;

    @Autowired
    public UniversityMenu(StudentsMenu studentsMenu, SubjectsMenu subjectsMenu, RoomsMenu roomsMenu,
            GroupsMenu groupsMenu, TeachersMenu teachersMenu) {
        this.studentsMenu = studentsMenu;
        this.subjectsMenu = subjectsMenu;
        this.roomsMenu = roomsMenu;
        this.groupsMenu = groupsMenu;
        this.teachersMenu = teachersMenu;
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
