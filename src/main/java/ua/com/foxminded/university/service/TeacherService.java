package ua.com.foxminded.university.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.TeacherDao;
import ua.com.foxminded.university.domain.Teacher;

@Service
public class TeacherService {
    private TeacherDao teacherDao;

    @Autowired
    public TeacherService(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public int addTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    public int removeTeacher(int teacherId) {
        return teacherDao.delete(teacherId);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherDao.findAll();
    }
}
