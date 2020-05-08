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

    public void addStudent(Student student, int groupId) {
        Group group = groupDao.find(groupId);
        student.setGroup(group);
        studentDao.save(student);
    }

    public void removeStudent(int studentId) {
        studentDao.delete(studentId);
    }

    public void changeStudentGroup(int studentId, int groupId) {
        Student student = studentDao.find(studentId);
        Group group = groupDao.find(groupId);
        student.setGroup(group);
        group.addStudent(student);
        studentDao.update(student);
        groupDao.update(group);
    }

    public List<Student> viewAllStudents() {
        return studentDao.findAll();
    }
}
