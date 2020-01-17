package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.domain.Group;

public interface GroupDao extends CrudDao<Group> {
    void getStudents();
}
