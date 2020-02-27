package ua.com.foxminded.university.dao;

import java.util.List;

public interface CrudDao<T> {
    T find(Integer id);
    int save(T model);
    int update(T model);
    int delete(Integer id);

    List<T> findAll();
}
