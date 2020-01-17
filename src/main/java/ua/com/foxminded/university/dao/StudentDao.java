package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.domain.Student;

public interface StudentDao extends CrudDao<Student> {
    void getGroup();
}
