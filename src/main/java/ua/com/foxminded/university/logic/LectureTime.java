package ua.com.foxminded.university.logic;

import lombok.Getter;

@Getter
public class LectureTime {
    private int startHour = 0;
    private int startMinute = 0;
    private int endHour = 0;
    private int endMinute = 0;

    public LectureTime(int startHour, int startMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = startHour + 1;
        this.endMinute = startMinute;
    }
}
