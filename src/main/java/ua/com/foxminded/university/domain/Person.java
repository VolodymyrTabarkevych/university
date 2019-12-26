package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Person {
    private String firstName = "This person has no first name";
    private String lastName = "This person has no last name";
    private int id;

    public Person(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
