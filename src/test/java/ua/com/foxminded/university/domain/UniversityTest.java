package ua.com.foxminded.university.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UniversityTest {
    static University university;
    static ObjectFinder finder;
    static boolean result;

    @BeforeAll
    public static void setUp() {
        university = new University();
        finder = new ObjectFinder(university);
    }

    @Test
    public void addNewTeacher_shouldAddExactTeacher() {
        university.addNewTeacher(1, "qqq", "www");
        result = university.getTeachers().contains(finder.findTeacherById(1));
        assertTrue(result);
    }

    @Test
    public void removeTeacher_shouldRemoveExactTeacher() {
        university.addNewTeacher(1, "qqq", "www");
        university.removeTeacher(1);
        result = university.getTeachers().contains(finder.findTeacherById(1));
        assertFalse(result);
    }

    @Test
    public void addNewStudentToUniversety_shouldAddStudent() {
        university.addNewStudentToUniversity(1, "qqq", "eee");
        result = university.findStudentsFromGroup().contains(finder.findStudentById(1));
        assertTrue(result);
    }
    @Test
    public void removeStudentFromUniversety_shouldRemoveTeacher() {
        university.addNewStudentToUniversity(1, "qqq", "eee");
        university.removeStudentFromUniversity(1);
        result = university.findStudentsFromGroup().contains(finder.findStudentById(1));
        assertFalse(result);
    }
    @Test
    public void changeStudentGroup_shouldChangeStudentGroupToExactGroup() {
        university.addNewGroup("MB-1");
        university.addNewGroup("MB-2");
        university.addNewStudentToUniversity(1, "qqq", "www");
        finder.findStudentById(1).setGroup(finder.findGroupByName("MB-1"));
        university.changeStudentGroup(1, "MB-2");
        result = finder.findStudentById(1).getGroup().equals(finder.findGroupByName("MB-2"));
        assertTrue(result);
    }
    @Test
    public void addNewGroup() {
        university.addNewGroup("MB-1");
        result = university.getGroups().contains(finder.findGroupByName("MB-1"));
        assertTrue(result);
    }
    @Test
    public void removeGroup() {
        university.addNewGroup("MB-1");
        university.removeGroup("MB-1");
        result = university.getGroups().contains(finder.findGroupByName("MB-1"));
        assertFalse(result);
    }
    @Test
    public void addNewSubject() {
        university.addNewSubject("Bio");
        result = university.getSubjects().contains(finder.findSubjectByName("Bio"));
        assertTrue(result);
    }
    @Test
    public void removeSubject() {
        university.addNewSubject("Bio");
        university.removeSubject("Bio");
        result = university.getSubjects().contains(finder.findSubjectByName("Bio"));
        assertFalse(result);
    }
    @Test
    public void addNewRoom() {
        university.addNewRoom(1);
        result = university.getRooms().contains(finder.findRoomByNumber(1));
        assertTrue(result);
    }
    @Test
    public void removeRoom() {
        university.addNewRoom(1);
        university.removeRoom(1);
        result = university.getRooms().contains(finder.findRoomByNumber(1));
        assertFalse(result);
    }
}
