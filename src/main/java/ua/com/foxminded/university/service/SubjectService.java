package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.domain.Subject;

@Service
public class SubjectService {
    private SubjectDao subjectDao;

    @Autowired
    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public int addSubject(Subject subject) {
        return subjectDao.save(subject);
    }

    public int removeSubject(int subjectId) {
        return subjectDao.delete(subjectId);
    }

    public List<Subject> viewAllSubjects() {
        return subjectDao.findAll();
    }
}
