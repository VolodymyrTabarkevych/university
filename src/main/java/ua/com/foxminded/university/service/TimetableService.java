package ua.com.foxminded.university.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.models.Lecture;
import ua.com.foxminded.university.models.Student;
import ua.com.foxminded.university.repositories.LectureRepository;
import ua.com.foxminded.university.repositories.StudentsRepository;

@Service
public class TimetableService {
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private StudentsRepository studentsRepository;

    public Set<Lecture> getStudentTimeTableForDay(int studentId, LocalDate date) {
        Student student = studentsRepository.findById(studentId).get();
        return lectureRepository.findAllLecturesByGroupIdAndDay(student.getGroup().getId(), date);
    }

    public Set<Lecture> getStudentTimetableForMonth(int studentId, LocalDate date) {
        Student student = studentsRepository.findById(studentId).get();
        return lectureRepository.findAllLecturesByGroupIdAndMonth(student.getGroup().getId(), date.getMonthValue());
    }

    public Set<Lecture> getTeacherTimetableForDay(int teacherId, LocalDate date) {
        return lectureRepository.findAllLecturesByTeacherIdAndDay(teacherId, date);
    }

    public Set<Lecture> getTeacherTimetableForMonth(int teacherId, LocalDate date) {
        return lectureRepository.findAllLecturesByTeacherIdAndMonth(teacherId, date.getMonthValue());
    }
}
