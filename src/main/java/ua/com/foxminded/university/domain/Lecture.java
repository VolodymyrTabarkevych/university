package ua.com.foxminded.university.domain;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class Lecture {
    private int lectureId = 0;
    private Subject subject = new Subject("");
    private Teacher teacher = new Teacher(0, "", "");
    private Group group = new Group("");
    private Room room = new Room(0);
    private Timestamp lectureBegin;
    private Timestamp lectureEnd;

    public Lecture() {

    }

    private Lecture(int lectureId, Subject subject, Teacher teacher, Group group, Timestamp lectureBegin,
            Timestamp lectureEnd, Room room) {
        this.lectureId = lectureId;
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.lectureBegin = lectureBegin;
        this.lectureEnd = lectureEnd;
        this.room = room;
    }

    public Lecture setLectureId(int lectureId) {
        this.lectureId = lectureId;
        return this;
    }

    public Lecture setSubject(Subject subject) {
        this.subject = subject;
        return this;

    }

    public Lecture setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public Lecture setGroup(Group group) {
        this.group = group;
        return this;
    }

    public Lecture setDateTimeBegin(Timestamp timestamp) {
        this.lectureBegin = timestamp;
        return this;
    }

    public Lecture setDateTimeEnd(Timestamp timestamp) {
        this.lectureEnd = timestamp;
        return this;
    }

    public Lecture setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Lecture build() {
        return new Lecture(this.lectureId, this.subject, this.teacher, this.group, this.lectureBegin, this.lectureEnd,
                this.room);
    }

    @Override
    public String toString() {
        return "Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + System.lineSeparator() + "Group: "
                + group.getName() + System.lineSeparator() + "Subject: " + subject.getName() + System.lineSeparator()
                + "Room: " + room.getNumber() + System.lineSeparator() + "Lecture begin: " + lectureBegin.getHours()
                + " " + lectureBegin.getMinutes() + System.lineSeparator() + "Lecture end: " + lectureEnd.getHours()
                + " " + lectureEnd.getMinutes();
    }
}
