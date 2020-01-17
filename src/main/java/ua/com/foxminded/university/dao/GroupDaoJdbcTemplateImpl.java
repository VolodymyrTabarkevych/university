package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Group;

public class GroupDaoJdbcTemplateImpl implements GroupDao {
    private JdbcTemplate template;
    private final String SQL_SELECT_ALL = "SELECT * FROM groups";

    public GroupDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Group> groupRowMapper = (ResultSet resultSet, int i) -> {
        return new Group(resultSet.getString("name"));
    };

    @Override
    public Group find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Group model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Group model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Group> findAll() {
        return template.query(SQL_SELECT_ALL, groupRowMapper);
    }

    @Override
    public void getStudents() {
        // TODO Auto-generated method stub

    }

}
