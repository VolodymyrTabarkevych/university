package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Teacher extends Person {
    private Set<Subject> subjects = new HashSet<>();

    public Teacher(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
}
