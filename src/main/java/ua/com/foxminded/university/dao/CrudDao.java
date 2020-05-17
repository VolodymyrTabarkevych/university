package ua.com.foxminded.university.dao;

import java.util.List;

public interface CrudDao<T> {
    T find(Integer id);

    void save(T model);

    void update(T model);

    void delete(Integer id);

    List<T> findAll();
}
