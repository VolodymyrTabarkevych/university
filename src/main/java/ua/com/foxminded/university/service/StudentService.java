package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.dao.StudentDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

@Service
public class StudentService {
    private StudentDao studentDao;
    private GroupDao groupDao;

    @Autowired
    public StudentService(StudentDao studentDao, GroupDao groupDao) {
        this.studentDao = studentDao;
        this.groupDao = groupDao;
    }

    public int addStudent(Student student, int groupId) {
        Group group = groupDao.find(groupId);
        student.setGroup(group);
        return studentDao.save(student);
    }

    public int removeStudent(int studentId) {
        return studentDao.delete(studentId);
    }

    public int changeStudentGroup(int studentId, int groupId) {
        Student student = studentDao.find(studentId);
        Group group = groupDao.find(groupId);
        student.setGroup(group);
        group.addStudent(student);
        return studentDao.update(student) + groupDao.update(group);
    }

    public List<Student> viewAllStudents() {
        return studentDao.findAll();
    }
}
