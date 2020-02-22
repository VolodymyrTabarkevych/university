package ua.com.foxminded.university.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Lecture {
    private int lectureId = 0;
    private Subject subject = new Subject("");
    private Teacher teacher = new Teacher(0, "", "");
    private Group group = new Group("");
    private Room room = new Room(0);
    private LocalDate date = LocalDate.of(1, 1, 1);
    private LocalTime startTime = LocalTime.of(0, 0);
    private LocalTime endTime = LocalTime.of(0, 0);;

    private Lecture() {

    }

    @Override
    public String toString() {
        return "Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + System.lineSeparator() + "Group: "
                + group.getName() + System.lineSeparator() + "Subject: " + subject.getName() + System.lineSeparator()
                + "Room: " + room.getNumber() + System.lineSeparator() + "Date: " + date.toString()
                + System.lineSeparator() + "Lecture begin: " + startTime.toString() + " Lecture end: "
                + endTime.toString();
    }

    public static class Builder {
        Lecture lecture;

        public Builder() {
            lecture = new Lecture();
        }

        public Builder setLectureId(int lectureId) {
            lecture.lectureId = lectureId;
            return this;
        }

        public Builder setSubject(Subject subject) {
            lecture.subject = subject;
            return this;

        }

        public Builder setTeacher(Teacher teacher) {
            lecture.teacher = teacher;
            return this;
        }

        public Builder setGroup(Group group) {
            lecture.group = group;
            return this;
        }

        public Builder setDate(LocalDate date) {
            lecture.date = date;
            return this;
        }

        public Builder setStartTime(LocalTime startTime) {
            lecture.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime) {
            lecture.endTime = endTime;
            return this;
        }

        public Builder setRoom(Room room) {
            lecture.room = room;
            return this;
        }

        public Lecture build() {
            return lecture;
        }
    }
}
