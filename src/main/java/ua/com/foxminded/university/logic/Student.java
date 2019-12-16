package ua.com.foxminded.university.logic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {
    private Group group;

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
