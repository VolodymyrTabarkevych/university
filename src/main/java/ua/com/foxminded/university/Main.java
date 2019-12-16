package ua.com.foxminded.university;

import java.io.IOException;

import ua.com.foxminded.university.text.ProgramMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        ProgramMenu universityMenu = new ProgramMenu();
        universityMenu.start();
    }
}
