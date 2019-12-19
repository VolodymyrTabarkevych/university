package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Subject {
    private String name = "";

    public Subject(String name) {
        this.name = name;
    }
}
