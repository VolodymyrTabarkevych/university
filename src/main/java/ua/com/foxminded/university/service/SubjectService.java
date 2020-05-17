package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.repositories.SubjectsRepository;

@Service
public class SubjectService {
    @Autowired
    private SubjectsRepository subjectsRepository;

    public void addSubject(Subject subject) throws EntityNameExistsException {
        for (Subject subjectFromDatabse : subjectsRepository.findAll()) {
            if (subjectFromDatabse.getName().equals(subject.getName())) {
                throw new EntityNameExistsException("Subject with such name is already exists!");
            }
        }
        subjectsRepository.save(subject);
    }

    public void removeSubject(int subjectId) {
        subjectsRepository.deleteById(subjectId);
    }

    public List<Subject> viewAllSubjects() {
        return subjectsRepository.findAll();
    }
}
