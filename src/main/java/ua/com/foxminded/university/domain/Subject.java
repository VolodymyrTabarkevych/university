package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Subject {
    private int id = 0;
    private String name = "This subject has no name!";
    private Set<Teacher> teachers = new HashSet<>();

    public Subject(String name) {
        this.name = name;
    }

    public Subject(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(id + ". " + name);
    }
}
