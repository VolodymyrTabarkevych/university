package ua.com.foxminded.university;

import java.io.IOException;

import ua.com.foxminded.university.text.UniversityMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        UniversityMenu universityMenu = new UniversityMenu();
        universityMenu.start();
    }
}
