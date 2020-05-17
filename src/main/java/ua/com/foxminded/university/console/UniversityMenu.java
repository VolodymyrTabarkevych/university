package ua.com.foxminded.university.console;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityMenu extends MenuText {
    @Autowired
    private StudentsMenu studentsMenu;
    @Autowired
    private SubjectsMenu subjectsMenu;
    @Autowired
    private RoomsMenu roomsMenu;
    @Autowired
    private GroupsMenu groupsMenu;
    @Autowired
    private TeachersMenu teachersMenu;

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
