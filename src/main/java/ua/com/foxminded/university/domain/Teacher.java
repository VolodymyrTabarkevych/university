package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends Person {
    private Set<Subject> subjects = new HashSet<>();

    public Teacher(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher() {

    }

    public void addSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
        }
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
}
