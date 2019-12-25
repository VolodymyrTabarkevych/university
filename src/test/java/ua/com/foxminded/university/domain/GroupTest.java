package ua.com.foxminded.university.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GroupTest {
    static Group group;
    static boolean result;
    static Student student1;
    static Student student2;
    static Student student3;

    @BeforeAll
    public static void setUp() {
        group = new Group("MB-55");
        student1 = new Student(1, "qqq", "qqq");
        student2 = new Student(2, "www", "www");
        student3 = new Student(3, "eee", "eee");
    }
    @AfterEach
    public void clean() {
        group.getStudents().clear();
    }
    @Test
    public void addStudent_shouldCreateExactStudent() {
        group.addStudent(student1);
        result = group.getStudents().contains(student1);
        assertTrue(result);
    }
    @Test
    public void removeStudent_shouldRemoveExactStudent() {
        group.addStudent(student1);
        group.removeStudent(student1);
        result = group.getStudents().contains(student1);
        assertFalse(result);
    }
    
}
