package ua.com.foxminded.university.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LectureFilterTest {
    static LectureFilter lectureFilter;
    static Set<Lecture> lectures;
    static Lecture lecture1;
    static Lecture lecture2;
    static Lecture lecture3;
    static Lecture lecture4;
    static Lecture lecture5;
    static Group group1;
    static Group group2;
    static Student student1;
    static Student student2;
    static Student student3;
    static Teacher teacher1;
    static Teacher teacher2;
    static boolean result;

    @BeforeAll
    public static void setUp() {
        teacher1 = new Teacher(1, "First", "Teacher");
        teacher2 = new Teacher(2, "Second", "Teacher");
        student1 = new Student(1, "Student", "First");
        student2 = new Student(2, "Student", "Second");
        student3 = new Student(3, "Student", "Third");
        group1 = new Group("MB-1");
        group2 = new Group("MB-2");
        group1.addStudent(student1);
        group1.addStudent(student3);
        group2.addStudent(student2);
        lectures = new HashSet<>();
        lecture1 = new Lecture().setLectureId(1).setTeacher(teacher1).setSubject(new Subject("Bio")).setGroup(group2)
                .setRoom(new Room(1)).setDate(2019, 6, 17).setTime(12, 30).build();
        lecture2 = new Lecture().setLectureId(2).setTeacher(teacher1).setSubject(new Subject("Bio")).setGroup(group1)
                .setRoom(new Room(1)).setDate(2019, 7, 17).setTime(10, 30).build();
        lecture3 = new Lecture().setLectureId(3).setTeacher(teacher2).setSubject(new Subject("Bio")).setGroup(group2)
                .setRoom(new Room(1)).setDate(2019, 6, 17).setTime(14, 30).build();
        lecture4 = new Lecture().setLectureId(4).setTeacher(teacher1)
                .setSubject(new Subject("Bio")).setGroup(group1).setRoom(new Room(1)).setDate(2019, 6, 20)
                .setTime(14, 30).build();
        lecture5 = new Lecture().setLectureId(5).setTeacher(teacher2).setSubject(new Subject("Bio")).setGroup(group1)
                .setRoom(new Room(1)).setDate(2019, 6, 17).setTime(9, 30).build();
        lectures.add(lecture1);
        lectures.add(lecture2);
        lectures.add(lecture3);
        lectures.add(lecture4);
        lectures.add(lecture5);
    }

    @AfterEach
    public void clean() {
        lectureFilter = new LectureFilter(lectures);
    }

    @Test
    public void forDay_shouldAddLecturesToFilterWithExectDay() {
        lectureFilter.forDay(new LectureDate(2019, 6, 17));
        result = lectureFilter.getFilteredLectures().contains(lecture1)
                && lectureFilter.getFilteredLectures().contains(lecture3);
        assertTrue(result);
    }

    @Test
    public void forMonth_shouldAddLecturesToFilterWithExectMonth() {
        lectureFilter.forMonth(6);
        result = lectureFilter.getFilteredLectures().contains(lecture1)
                && lectureFilter.getFilteredLectures().contains(lecture3)
                && lectureFilter.getFilteredLectures().contains(lecture4);
        assertTrue(result);
    }

    @Test
    public void forStudent_shouldAddLecturesToFilterWithExectStudent() {
        lectureFilter.forStudent(1);
        result = lectureFilter.getFilteredLectures().contains(lecture2)
                && lectureFilter.getFilteredLectures().contains(lecture4);
        assertTrue(result);
    }

    @Test
    public void forTeacher_shouldAddLecturesToFilterWithExectTeacher() {
        lectureFilter = new LectureFilter(lectures);
        lectureFilter.forTeacher(1);
        result = lectureFilter.getFilteredLectures().contains(lecture1)
                && lectureFilter.getFilteredLectures().contains(lecture2)
                && lectureFilter.getFilteredLectures().contains(lecture4);
        assertTrue(result);
    }

    @Test
    public void forDayIfFilteredLecturesNotEmpty_shouldAddLecturesToFilterWithExectStudentAndDay() {
        lectureFilter.forStudent(1).forDay(new LectureDate(2019, 6, 20));
        result = lectureFilter.getFilteredLectures().contains(lecture4);
        assertTrue(result);
    }

    @Test
    public void forDayIfFilteredLecturesNotEmpty_shouldAddLecturesToFilterWithExectTeacherAndDay() {
        lectureFilter.forTeacher(2).forDay(new LectureDate(2019, 6, 17));
        result = lectureFilter.getFilteredLectures().contains(lecture3)
                && lectureFilter.getFilteredLectures().contains(lecture5);
        assertTrue(result);
    }

    @Test
    public void forMonthIfFilteredLecturesNotEmpty_shouldAddLecturesToFilterWithExectStudentAndMonth() {
        lectureFilter.forStudent(2).forMonth(6);
        result = lectureFilter.getFilteredLectures().contains(lecture3)
                && lectureFilter.getFilteredLectures().contains(lecture1);
        assertTrue(result);
    }
    @Test
    public void forMonthIfFilteredLecturesNotEmpty_shouldAddLecturesToFilterWithExectTeacherAndMonth() {
        lectureFilter.forTeacher(2).forMonth(6);
        result = lectureFilter.getFilteredLectures().contains(lecture3)
                && lectureFilter.getFilteredLectures().contains(lecture5);
        assertTrue(result);
    }
}
