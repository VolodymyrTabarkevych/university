package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

import lombok.Setter;

@Setter
public class Timetable {
    private Set<Lecture> lectures = new HashSet<>();

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
    }

    public Filter filter() {
        return new Filter(lectures);
    }
}
