package ua.com.foxminded.university.logic;

import java.util.Set;

public class Teacher extends Person {
    private Set<Subject> subjects;

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
