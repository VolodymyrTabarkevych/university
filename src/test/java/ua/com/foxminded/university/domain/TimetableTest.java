package ua.com.foxminded.university.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.domain.Timetable;

class TimetableTest {

    static Timetable timetable;
    static boolean result;
    static Lecture lecture;
    static Lecture lecture2;
    static Lecture lecture3;

    @BeforeAll
    public static void setUp() {
        Set<Lecture> lectures = new HashSet<>();
        timetable = new Timetable(lectures);
        lecture = new Lecture.Builder().setLectureId(1).setDate(LocalDate.of(2018, 7, 17)).setStartTime(LocalTime.of(11, 35)).setRoom(new Room(2))
                .setGroup(new Group("MB-1")).setSubject(new Subject("Bio")).setTeacher(new Teacher(1, "qqq", "www"))
                .build();
        lecture2 = new Lecture.Builder().setLectureId(2).setDate(LocalDate.of(2018, 7, 17)).setStartTime(LocalTime.of(10, 30)).setRoom(new Room(2))
                .setGroup(new Group("MB-1")).setSubject(new Subject("Bio")).setTeacher(new Teacher(1, "qqq", "www"))
                .build();
        lecture3 = new Lecture.Builder().setLectureId(3).setDate(LocalDate.of(2018, 7, 17)).setStartTime(LocalTime.of(10, 30)).setRoom(new Room(2))
                .setGroup(new Group("MB-1")).setSubject(new Subject("Bio")).setTeacher(new Teacher(1, "qqq", "www"))
                .build();
    }

    @AfterEach
    public void clean() {
        timetable.getLectures().clear();
    }

    @Test
    public void addLecture_shouldAddExactLecture() {
        timetable.addLecture(lecture);
        result = timetable.getLectures().contains(lecture);
        assertTrue(result);
    }

    @Test
    public void removeLecture_shouldRemoveExactLecture() {
        timetable.addLecture(lecture);
        timetable.removeLecture(1);
        result = timetable.getLectures().contains(lecture);
        assertFalse(result);
    }

    @Test
    public void addLecture_sameDateAndTimeAndRoom_shouldntAddLecture() {
        timetable.addLecture(lecture2);
        timetable.addLecture(lecture3);
        result = timetable.getLectures().contains(lecture3);
        assertFalse(result);
    }

    @Test
    public void addLecture_sameDateButDifferentTime_shouldAddLecture() {
        timetable.addLecture(lecture);
        timetable.addLecture(lecture2);
        result = timetable.getLectures().contains(lecture2);
        assertTrue(result);
    }
}
