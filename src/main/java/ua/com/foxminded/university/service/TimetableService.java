package ua.com.foxminded.university.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.LectureDao;
import ua.com.foxminded.university.dao.StudentDao;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Student;

@Service
public class TimetableService {
    private LectureDao lectureDao;
    private StudentDao studentDao;

    @Autowired
    public TimetableService(DataSource dataSource) {
        this.lectureDao = new LectureDao(dataSource);
        this.studentDao = new StudentDao(dataSource);
    }

    public Set<Lecture> getStudentTimeTableForDay(int studentId, LocalDate date) {
        Student student = studentDao.find(studentId);
        return new HashSet<Lecture>(lectureDao.findAllLecturesByGroupIdAndDay(student.getGroup().getId(), date));
    }

    public Set<Lecture> getStudentTimetableForMonth(int studentId, LocalDate date) {
        Student student = studentDao.find(studentId);
        return new HashSet<Lecture>(lectureDao.findAllLecturesByGroupIdAndMonth(student.getGroup().getId(), date));
    }

    public Set<Lecture> getTeacherTimetableForDay(int teacherId, LocalDate date) {
        return new HashSet<Lecture>(lectureDao.findAllLecturesByTeacherIdAndDay(teacherId, date));
    }

    public Set<Lecture> getTeacherTimetableForMonth(int teacherId, LocalDate date) {
        return new HashSet<Lecture>(lectureDao.findAllLecturesByTeacherIdAndMonth(teacherId, date));
    }
}
