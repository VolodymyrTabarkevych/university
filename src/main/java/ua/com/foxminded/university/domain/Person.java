package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Person {
    private String firstName = "";
    private String lastName = "";
    private int id;

    public Person(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
