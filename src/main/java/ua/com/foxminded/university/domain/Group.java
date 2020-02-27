package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Group {
    private int id = 0;
    private String name = "This group has no name!";
    private Set<Student> students = new HashSet<>();

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(int id) {
        this.id = id;
    }

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    public void addStudents(Set<Student> students) {
        this.students = students;
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGroup(null);
    }
}
