package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

@Repository
public class GroupDao implements CrudDao<Group> {
    private JdbcTemplate template;
    private StudentDao studentDaoJdbcTemplateImpl;
    private final String SQL_FIND_ALL = "SELECT * FROM groups";
    private final String SQL_FIND_BY_ID = "SELECT * FROM groups WHERE id = ?";
    private final String SQL_SAVE_GROUP = "INSERT INTO groups (name) VALUES (?)";
    private final String SQL_UPDATE_GROUP = "UPDATE groups SET name = ?, WHERE id = ?";
    private final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE id = ?";

    @Autowired
    public GroupDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.studentDaoJdbcTemplateImpl = new StudentDao(dataSource);
    }

    private RowMapper<Group> groupRowMapper = (ResultSet resultSet, int i) -> {
        Group group = new Group(resultSet.getInt("id"), resultSet.getString("name"));
        group.addStudents(new HashSet<Student>(studentDaoJdbcTemplateImpl.findAllByGroupId(group.getId())));
        return group;
    };

    @Override
    public Group find(Integer id) {
        Group group = template.query(SQL_FIND_BY_ID, groupRowMapper, id).get(0);
        return group;
    }

    @Override
    public void save(Group group) {
        template.update(SQL_SAVE_GROUP, group.getName());
    }

    @Override
    public void update(Group group) {
        template.update(SQL_UPDATE_GROUP, group.getName(), group.getId());
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_GROUP, id);
    }

    @Override
    public List<Group> findAll() {
        return template.query(SQL_FIND_ALL, groupRowMapper);
    }
}
