package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.models.Group;
import ua.com.foxminded.university.models.Student;
import ua.com.foxminded.university.repositories.GroupsRepository;
import ua.com.foxminded.university.repositories.StudentsRepository;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private GroupsRepository groupsRepository;

    public void addStudent(Student student, int groupId) {
        Group group = groupsRepository.findById(groupId).get();
        student.setGroup(group);
        studentsRepository.save(student);
    }

    public void removeStudent(int studentId) {
        studentsRepository.deleteById(studentId);
    }

    public void changeStudentGroup(int studentId, int groupId) {
        Student student = studentsRepository.findById(studentId).get();
        Group group = groupsRepository.findById(groupId).get();
        student.setGroup(group);
        studentsRepository.flush();
    }

    public List<Student> viewAllStudents() {
        return studentsRepository.findAll();
    }
}
