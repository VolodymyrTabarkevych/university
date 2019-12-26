package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Group {
    private String name = "This group has no name!";
    private Set<Student> students = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGroup(null);
    }
}
