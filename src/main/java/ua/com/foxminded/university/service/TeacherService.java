package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.dao.TeacherDao;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

@Service
public class TeacherService {
    private TeacherDao teacherDao;
    private SubjectDao subjectDao;

    @Autowired
    public TeacherService(TeacherDao teacherDao, SubjectDao subjectDao) {
        this.teacherDao = teacherDao;
        this.subjectDao = subjectDao;
    }

    public void addTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }

    public void removeTeacher(int teacherId) {
        teacherDao.delete(teacherId);
    }

    public void addSubjectToTeacher(int teacherId, int subjectId) {
        Teacher teacher = teacherDao.find(teacherId);
        Subject subject = subjectDao.find(subjectId);
        teacher.addSubject(subject);
        teacherDao.update(teacher);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherDao.findAll();
    }

    public List<Subject> viewAllTeacherSubject(int teacherId) {
        return teacherDao.findAllSubjects(teacherId);
    }
}
