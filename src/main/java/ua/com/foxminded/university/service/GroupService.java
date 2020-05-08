package ua.com.foxminded.university.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.CrudDao;
import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;
import ua.com.foxminded.university.exceptions.EntityNameExistsException;

@Service
public class GroupService {
    private GroupDao groupDao;
    private CrudDao<Student> studentDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void addGroup(Group group) throws EntityNameExistsException {
        for (Group groupFromDatabase : groupDao.findAll()) {
            if (groupFromDatabase.getName().equals(group.getName())) {
                throw new EntityNameExistsException("Group with such name is already exists!");
            }
        }
        groupDao.save(group);
    }

    public void removeGroup(Integer id) {
        groupDao.delete(id);
    }

    public void addStudentToGroup(int groupId, int studentId) {
        Student student = studentDao.find(studentId);
        Group group = groupDao.find(groupId);
        group.addStudent(student);
        student.setGroup(group);
        studentDao.update(student);
        groupDao.update(group);
    }

    public Set<Student> viewAllStudentsInGroup(int groupId) {
        Group group = groupDao.find(groupId);
        return group.getStudents();
    }

    public List<Group> viewAllGroups() {
        return groupDao.findAll();
    }

}
