package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Person {
    private String firstName = "This person has no first name";
    private String lastName = "This person has no last name";
    private int id = 0;

    public Person(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(id + ". " + firstName + " " + lastName);
    }
}
