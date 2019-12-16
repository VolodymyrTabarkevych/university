package ua.com.foxminded.university.logic;

import lombok.Getter;

@Getter
public class Lecture{
    private Subject subject = null;
    private Teacher teacher = null;
    private Group group = null;
    private LectureDate date = null;
    private LectureTime time = null;
    private Room room = null;

    public Lecture() {

    }

    private Lecture(Subject subject, Teacher teacher, Group group, LectureDate date, LectureTime time, Room room) {
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.date = date;
        this.time = time;
        this.room = room;
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

    public Lecture setDate(LectureDate date) {
        this.date = date;
        return this;
    }

    public Lecture setTime(LectureTime time) {
        this.time = time;
        return this;
    }

    public Lecture setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Lecture build() {
        return new Lecture(this.subject, this.teacher, this.group, this.date, this.time, this.room);
    }

}
