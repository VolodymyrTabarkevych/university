package ua.com.foxminded.university.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {
    private Group group = new Group();

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(int id) {
        super(id);
    }

    public Student(String firstName, String lastName, Group group) {
        super(firstName, lastName);
        this.group = group;
    }
}
