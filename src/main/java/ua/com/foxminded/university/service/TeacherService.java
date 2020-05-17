package ua.com.foxminded.university.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.models.Teacher;
import ua.com.foxminded.university.repositories.SubjectsRepository;
import ua.com.foxminded.university.repositories.TeachersRepository;

@Service
public class TeacherService {
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private SubjectsRepository subjectsRepository;

    public void addTeacher(Teacher teacher) {
        teachersRepository.save(teacher);
    }

    public void removeTeacher(int teacherId) {
        teachersRepository.deleteById(teacherId);
    }

    public void addSubjectToTeacher(int teacherId, int subjectId) {
        Teacher teacher = teachersRepository.findById(teacherId).get();
        Subject subject = subjectsRepository.findById(subjectId).get();
        for (Subject teacherSubject : teacher.getSubjects())
            if (teacherSubject.getName().equals(subject.getName())) {
                throw new EntityNameExistsException("This teacher already has subject with such name!");
            }
        teacher.getSubjects().add(subject);
        subject.getTeachers().add(teacher);
        teachersRepository.saveAndFlush(teacher);
        subjectsRepository.saveAndFlush(subject);

    }

    public List<Teacher> viewAllTeachers() {
        return teachersRepository.findAll();
    }

    public Set<Subject> viewAllTeacherSubject(int teacherId) {
        Teacher teacher = teachersRepository.findById(teacherId).get();
        return teacher.getSubjects();
    }
}
