package ua.com.foxminded.universit.service;

import java.util.List;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.domain.Subject;

public class SubjectService {
    private SubjectDao subjectDao;

    public SubjectService(DataSource dataSource) {
        this.subjectDao = new SubjectDao(dataSource);
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
