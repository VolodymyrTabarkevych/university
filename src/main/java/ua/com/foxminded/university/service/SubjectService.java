package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.exceptions.EntityNameExistsException;

@Service
public class SubjectService {
    private SubjectDao subjectDao;

    @Autowired
    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public void addSubject(Subject subject) throws EntityNameExistsException {
        for (Subject subjectFromDatabse : subjectDao.findAll()) {
            if (subjectFromDatabse.getName().equals(subject.getName())) {
                throw new EntityNameExistsException("Subject with such name is already exists!");
            }
        }
        subjectDao.save(subject);
    }

    public void removeSubject(int subjectId) {
        subjectDao.delete(subjectId);
    }

    public List<Subject> viewAllSubjects() {
        return subjectDao.findAll();
    }
}
