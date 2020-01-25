package ua.com.foxminded.university.dao;

import java.util.List;

import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public interface TeacherDao extends CrudDao<Teacher> {
    Teacher findAllSubjects(Integer teacherId);
}
