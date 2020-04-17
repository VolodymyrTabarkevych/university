package ua.com.foxminded.university.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Lecture {
    private int lectureId;
    private Subject subject;
    private Teacher teacher;
    private Group group;
    private Room room;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public String toString() {
        return "Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + System.lineSeparator() + "Group: "
                + group.getName() + System.lineSeparator() + "Subject: " + subject.getName() + System.lineSeparator()
                + "Room: " + room.getNumber() + System.lineSeparator() + "Date: " + date.toString()
                + System.lineSeparator() + "Lecture begin: " + startTime.toString() + " Lecture end: "
                + endTime.toString();
    }
}
