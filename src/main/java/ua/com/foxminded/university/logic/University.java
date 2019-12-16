package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class University {
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Student> students = new HashSet<>();
    private Set<Group> groups = new HashSet<>();
    private Set<Subject> subjects = new HashSet<>();
    private Set<Room> rooms = new HashSet<>();
    private Timetable timetable = new Timetable();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStudentToUniversity(Student student) {
        students.add(student);
    }

    public void removeStudentFromUniversity(Student student) {
        students.remove(student);
    }

    public void changeStudentGroup(Student student, Group group) {
        student.setGroup(group);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }
    

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void viewAllTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getFirstName() + " " + teacher.getLastName());
        }
    }

    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public void viewAllGroups() {
        for (Group group : groups) {
            System.out.println(group.getName());
        }
    }

    public void viewAllSubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject.getName());
        }
    }

    public void viewAllRooms() {
        for (Room room : rooms) {
            System.out.println(room.getNumber());
        }
    }
}
