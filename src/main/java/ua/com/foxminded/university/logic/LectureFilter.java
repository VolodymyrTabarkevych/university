package ua.com.foxminded.university.logic;

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
                if (lecture.getDate().getMonth() == numberOfMonth) {
                    filteredLectures.add(lecture);
                }
            }
        } else {
            filteredLectures.clear();
            if (isForStudentUsed) {
                for (Lecture lecture : lectures) {
                    for (Student student : lecture.getGroup().getStudents()) {
                        if (student.getId() == personId && lecture.getDate().getMonth() == numberOfMonth) {
                            filteredLectures.add(lecture);
                        }
                    }
                }
            } else if (isForTeacherUsed) {
                for (Lecture lecture : lectures) {
                    if (lecture.getTeacher().getId() == personId && lecture.getDate().getMonth() == numberOfMonth) {
                        filteredLectures.add(lecture);
                    }
                }
            }
        }
        return this;
    }

    public LectureFilter forDay(int dayOfMonth) {
        if (filteredLectures.isEmpty()) {
            for (Lecture lecture : lectures) {
                if (lecture.getDate().getDay() == dayOfMonth) {
                    filteredLectures.add(lecture);
                }
            }
        } else {
            filteredLectures.clear();
            if (isForStudentUsed) {
                for (Lecture lecture : lectures) {
                    for (Student student : lecture.getGroup().getStudents()) {
                        if (student.getId() == personId && lecture.getDate().getDay() == dayOfMonth) {
                            filteredLectures.add(lecture);
                        }
                    }
                }
            } else if (isForTeacherUsed) {
                for (Lecture lecture : lectures) {
                    if (lecture.getTeacher().getId() == personId && lecture.getDate().getDay() == dayOfMonth) {
                        filteredLectures.add(lecture);
                    }
                }
            }
        }
        return this;
    }

    public Set<Lecture> getFilteredLectures() {
        return filteredLectures;
    }
}
