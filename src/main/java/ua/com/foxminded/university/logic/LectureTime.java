package ua.com.foxminded.university.logic;

import lombok.Getter;

@Getter
public class LectureTime {
    private int hour = 0;
    private int minute = 0;

    public LectureTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
