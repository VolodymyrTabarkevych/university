package ua.com.foxminded.university.console;

import java.io.BufferedReader;

class UniversityMenu extends Menu {
    private StudentsMenu studentsMenu = new StudentsMenu();
    private SubjectsMenu subjectsMenu = new SubjectsMenu();
    private RoomsMenu roomsMenu = new RoomsMenu();
    private GroupsMenu groupsMenu = new GroupsMenu();
    private TeachersMenu teachersMenu = new TeachersMenu();

    void start(String selectedOption, BufferedReader reader) {
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
