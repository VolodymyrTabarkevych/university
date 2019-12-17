package ua.com.foxminded.university;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.university.logic.Lecture;
import ua.com.foxminded.university.logic.Timetable;

class TimetableTest {

	static Timetable timetable;
	static int expected;
	static int actual;
	Lecture lecture = new Lecture();

	@BeforeAll
	public static void setUp() {
		Lecture lecture = new Lecture().setLectureId(1);
		Lecture lecture2 = new Lecture().setLectureId(2);
		timetable = new Timetable();
		timetable.addLecture(lecture);
		timetable.addLecture(lecture2);
	}

	@Test
	public void addLecture_shouldAddLecture() {
		expected = timetable.getLectures().size() + 1;
		timetable.addLecture(lecture);
		actual = timetable.getLectures().size();
		assertEquals(expected, actual);
	}

	@Test
	public void removeLecture_shouldRemoveLecture() {
		expected = timetable.getLectures().size() - 1;
		timetable.removeLecture(1);
		actual = timetable.getLectures().size();
		assertEquals(expected, actual);
	}

	@Test
	public void removeLecture_ifUniversityHasNoLectures_shouldDoNothing() {
		Timetable timetable = new Timetable();
		timetable.getLectures().clear();
		expected = timetable.getLectures().size();
		timetable.removeLecture(1);
		actual = timetable.getLectures().size();
		assertEquals(expected, actual);
	}
}
