package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Group {
    private String name = "";
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

    public void showAllStudents() {
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public Student findStudentById(int id) {
        Student result = null;
        for (Student student : students) {
            if (student.getId() == id) {
                result = student;
            }
        }
        return result;
    }
}
