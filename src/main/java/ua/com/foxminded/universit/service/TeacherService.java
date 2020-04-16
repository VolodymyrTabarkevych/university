package ua.com.foxminded.universit.service;

import java.util.List;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.TeacherDao;
import ua.com.foxminded.university.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao;

    public TeacherService(DataSource dataSource) {
        this.teacherDao = new TeacherDao(dataSource);
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
