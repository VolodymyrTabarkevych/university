package ua.com.foxminded.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Group;
import ua.com.foxminded.university.models.Student;
import ua.com.foxminded.university.repositories.GroupsRepository;
import ua.com.foxminded.university.repositories.StudentsRepository;

@Service
public class GroupService {
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private StudentsRepository studentsRepository;

    public void addGroup(Group group) throws EntityNameExistsException {
        for (Group groupFromDatabase : groupsRepository.findAll()) {
            if (groupFromDatabase.getName().equals(group.getName())) {
                throw new EntityNameExistsException("Group with such name is already exists!");
            }
        }
        groupsRepository.save(group);
    }

    public void removeGroup(Integer id) {
        groupsRepository.deleteById(id);
    }

    public void addStudentToGroup(int groupId, int studentId) {
        Student student = studentsRepository.findById(studentId).get();
        Group group = groupsRepository.findById(groupId).get();
        group.getStudents().add(student);
        student.setGroup(group);
        studentsRepository.flush();
        groupsRepository.flush();
    }

    public Set<Student> viewAllStudentsInGroup(int groupId) {
        Group group = groupsRepository.findById(groupId).get();
        System.out.println(group.getStudents().size());
        return group.getStudents();
    }

    public List<Group> viewAllGroups() {
        List<Group> groups = new ArrayList<>();
        groups = groupsRepository.findAll();
        return groups;
    }

}
