package ua.com.foxminded.university.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.CrudDao;
import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

@Service
public class GroupService {
    private GroupDao groupDao;
    private CrudDao<Student> studentDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
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
