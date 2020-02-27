package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Room {
    private int id = 0;
    private int number = 0;

    public Room(int number) {
        this.number = number;
    }

    public Room(int id, int number) {
        this.id = id;
        this.number = number;
    }
}
