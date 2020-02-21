package ua.com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LectureFilter {
    private Set<Lecture> lectures;
    private Set<Lecture> filteredLectures = new HashSet<>();
    private Boolean isForStudentUsed = false;
    private Boolean isForTeacherUsed = false;
    private int personId = 0;

    public LectureFilter(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public LectureFilter forStudent(int studentId) {
        isForStudentUsed = true;
        for (Lecture lecture : lectures) {
            for (Student student : lecture.getGroup().getStudents()) {
                if (student.getId() == studentId) {
                    filteredLectures.add(lecture);
                }
            }
        }
        personId = studentId;
        return this;
    }

    public LectureFilter forTeacher(int teacherId) {
        isForTeacherUsed = true;
        for (Lecture lecture : lectures) {
            if (lecture.getTeacher().getId() == teacherId) {
                filteredLectures.add(lecture);
            }
        }
        personId = teacherId;
        return this;
    }

    public LectureFilter forMonth(int numberOfMonth) {
        if (filteredLectures.isEmpty()) {
            for (Lecture lecture : lectures) {
                if (lecture.getDate().getMonthValue() == numberOfMonth) {
                    filteredLectures.add(lecture);
                }
            }
        } else {
            forMonthIfFilteredLecturesNotEmpty(numberOfMonth);
        }
        return this;
    }

    public LectureFilter forDay(LocalDate date) {
        if (filteredLectures.isEmpty()) {
            for (Lecture lecture : lectures) {
                if (lecture.getDate().getYear() == date.getYear()
                        && lecture.getDate().getMonthValue() == date.getMonthValue()
                        && lecture.getDate().getDayOfMonth() == date.getDayOfMonth()) {
                    filteredLectures.add(lecture);
                }
            }
        } else {
            forDayIfFilteredLecturesNotEmpty(date);
        }
        return this;
    }

    private LectureFilter forDayIfFilteredLecturesNotEmpty(LocalDate date) {
        filteredLectures.clear();
        if (Boolean.TRUE.equals(isForStudentUsed)) {
            for (Lecture lecture : lectures) {
                for (Student student : lecture.getGroup().getStudents()) {
                    if (student.getId() == personId && lecture.getDate().getYear() == date.getYear()
                            && lecture.getDate().getMonthValue() == date.getMonthValue()
                            && lecture.getDate().getDayOfMonth() == date.getDayOfMonth()) {
                        filteredLectures.add(lecture);
                    }
                }
            }
        } else if (Boolean.TRUE.equals(isForTeacherUsed)) {
            for (Lecture lecture : lectures) {
                if (lecture.getTeacher().getId() == personId && lecture.getDate().getYear() == date.getYear()
                        && lecture.getDate().getMonthValue() == date.getMonthValue()
                        && lecture.getDate().getDayOfMonth() == date.getDayOfMonth()) {
                    filteredLectures.add(lecture);
                }
            }
        }
        return this;
    }

    private LectureFilter forMonthIfFilteredLecturesNotEmpty(int numberOfMonth) {
        filteredLectures.clear();
        if (Boolean.TRUE.equals(isForStudentUsed)) {
            for (Lecture lecture : lectures) {
                for (Student student : lecture.getGroup().getStudents()) {
                    if (student.getId() == personId && lecture.getDate().getMonthValue() == numberOfMonth) {
                        filteredLectures.add(lecture);
                    }
                }
            }
        } else if (Boolean.TRUE.equals(isForTeacherUsed)) {
            for (Lecture lecture : lectures) {
                if (lecture.getTeacher().getId() == personId && lecture.getDate().getMonthValue() == numberOfMonth) {
                    filteredLectures.add(lecture);
                }
            }
        }
        return this;
    }

    public Set<Lecture> getFilteredLectures() {
        return filteredLectures;
    }
}
