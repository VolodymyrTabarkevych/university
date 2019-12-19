package ua.com.foxminded.university.domain;

import lombok.Getter;

@Getter
public class Lecture {
    private int lectureId = 0;
    private Subject subject = new Subject("");
    private Teacher teacher = new Teacher(0, "", "");
    private Group group = new Group("");
    private LectureDate date = new LectureDate(0, 0, 0);
    private LectureTime time = new LectureTime(0, 0);
    private Room room = new Room(0);

    public Lecture() {

    }

    private Lecture(int lectureId, Subject subject, Teacher teacher, Group group, LectureDate date, LectureTime time,
            Room room) {
        this.lectureId = lectureId;
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.date = date;
        this.time = time;
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
        return new Lecture(this.lectureId, this.subject, this.teacher, this.group, this.date, this.time, this.room);
    }

}
