package ua.com.foxminded.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.LectureDate;
import ua.com.foxminded.university.domain.LectureTime;
import ua.com.foxminded.university.domain.Timetable;

class TimetableTest {

    static Timetable timetable;
    static boolean result;
    static Lecture lecture;
    static Lecture lecture2;
    static Lecture lecture3;

    @BeforeAll
    public static void setUp() {
        timetable = new Timetable();
        lecture = new Lecture().setLectureId(1).setDate(2018, 7, 17).setTime(11, 35).setRoom();;
        lecture2 = new Lecture().setLectureId(2).setDate(2018, 7, 17).setTime(10, 30);
        lecture3 = new Lecture().setLectureId(3).setDate(2018, 7, 17).setTime(10, 30);
        timetable.addLecture(lecture2);
    }

    @Test
    public void addLecture_shouldAddExactLecture() {
        timetable.addLecture(lecture);
        result = timetable.getLectures().contains(lecture);
        assertTrue(result);
    }

    @Test
    public void removeLecture_shouldRemoveExactLecture() {
        timetable.removeLecture(2);
        result = timetable.getLectures().contains(lecture2);
        assertFalse(result);
    }

    @Test
    public void addLecture_sameDateAndTime_shouldntAddLecture() {
        timetable.addLecture(lecture3);
        result = timetable.getLectures().contains(lecture3);
        assertFalse(result);
    }
    @Test
    public void addLecture_sameDateButDifferentTime_shouldAddLecture() {
        timetable.addLecture(lecture);
        result = timetable.getLectures().contains(lecture);
        assertTrue(result);
    }
}
