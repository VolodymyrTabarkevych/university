package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

public class Filter {
    private Set<Lecture> lectures;
    private Set<Lecture> filteredLectures = new HashSet<>();
    private int studentId = 0;
    private int teacherId = 0;

    public Filter(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Filter forStudent(int studentId) {
        if (this.studentId == 0) {
            this.studentId = studentId;
            for (Lecture lecture : lectures) {
                for (Student student : lecture.getGroup().getStudents()) {
                    if (student.getId() == studentId) {
                        filteredLectures.add(lecture);
                    }
                }
            }
        } else {
            System.out.println("Lectures for student has already been added!");
        }
        return this;
    }

    public Filter forTeacher(int teacherId) {
        if (this.teacherId != 0) {
            this.teacherId = teacherId;
            for (Lecture lecture : lectures) {
                if (lecture.getTeacher().getId() == teacherId) {
                    filteredLectures.add(lecture);
                }
            }
        } else {
            System.out.println("Lectures for teacher has already been added!");
        }
        return this;
    }

    /*
     * public Filter forMonth(Month month) { for (Lecture lecture : lectures) { if
     * (lecture.getDate().getMonth() == month.getValue()) {
     * filteredLectures.add(lecture); } } return this; }
     */
    public Filter forDay(int dayOfMonth) {
        for (Lecture lecture : lectures) {
            if (lecture.getDate().getDay() == dayOfMonth) {
                filteredLectures.add(lecture);
            }
        }
        return this;
    }

    public Set<Lecture> getFilteredLectures() {
        return filteredLectures;
    }
}
