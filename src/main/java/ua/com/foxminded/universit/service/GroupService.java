package ua.com.foxminded.universit.service;

import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.dao.StudentDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

public class GroupService {
    private GroupDao groupDao;
    private StudentDao studentDao;

    public GroupService(DataSource dataSource) {
        this.groupDao = new GroupDao(dataSource);
        this.studentDao = new StudentDao(dataSource);
    }

    public int addGroup(Group group) {
        return groupDao.save(group);
    }

    public int removeGroup(Integer id) {
        return groupDao.delete(id);
    }

    public int addStudentToGroup(int groupId, int studentId) {
        Student student = studentDao.find(studentId);
        Group group = groupDao.find(groupId);
        group.addStudent(student);
        student.setGroup(group);
        return studentDao.update(student) + groupDao.update(group);
    }

    public Set<Student> viewAllStudentsInGroup(int groupId) {
        Group group = groupDao.find(groupId);
        return group.getStudents();
    }

    public List<Group> viewAllGroups() {
        return groupDao.findAll();
    }

}
