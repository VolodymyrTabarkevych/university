package ua.com.foxminded.university.logic;

import lombok.Getter;

@Getter
public class Subject {
    private String name = "";

    public Subject(String name) {
        this.name = name;
    }
}
