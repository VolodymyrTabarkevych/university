package ua.com.foxminded.university.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.foxminded.university.domain.Lecture;

public class LectureDaoJdbcTemplateImpl implements CrudDao<Lecture> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM lectures";
    private final String SQL_FIND_BY_ID = "SELECT * FROM lectures WHERE id = ?";
    private final String SQL_SAVE_LECTURES = "INSERT INTO lectures (number) VALUES (?)";
    private final String SQL_UPDATE_LECTURES = "UPDATE lectures SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_LECTURES = "DELETE FROM lectures WHERE id = ?";

    @Override
    public Lecture find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Lecture model) {
        template.update(psc)
    }

    @Override
    public void update(Lecture model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Lecture> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
