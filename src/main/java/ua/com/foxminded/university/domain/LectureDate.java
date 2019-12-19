package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class LectureDate {
    private int year = 0;
    private int month = 0;
    private int day = 0;

    public LectureDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
