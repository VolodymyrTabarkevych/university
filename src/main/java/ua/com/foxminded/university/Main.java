package ua.com.foxminded.university;

import java.io.IOException;

import ua.com.foxminded.university.menu.ProgramMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        ProgramMenu programMenu = new ProgramMenu();
        programMenu.start();
    }
}
