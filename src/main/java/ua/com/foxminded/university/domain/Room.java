package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Room {
    private int number = 0;

    public Room(int number) {
        this.number = number;
    }
}
