package ua.com.foxminded.university.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TeacherTest {
    static Teacher teacher;
    static Subject subject1;
    static Subject subject2;
    static boolean result;

    @BeforeAll
    public static void setUp() {
        teacher = new Teacher(1, "Teacher", "First");
        subject1 = new Subject("Bio");
        subject2 = new Subject("Math");
    }

    @AfterAll
    public static void clear() {
        teacher.getSubjects().clear();
    }

    @Test
    public void addSubject_shouldAddSubject() {
        teacher.addSubject(subject1);
        result = teacher.getSubjects().contains(subject1);
        assertTrue(result);
    }

    @Test
    public void removeSubject_shouldRemoveSubject() {
        teacher.addSubject(subject1);
        teacher.removeSubject(subject1);
        result = teacher.getSubjects().contains(subject1);
        assertFalse(result);
    }
}
