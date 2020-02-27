package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

public class GroupDao implements CrudDao<Group> {
    private JdbcTemplate template;
    private StudentDao studentDaoJdbcTemplateImpl;
    private final String SQL_FIND_ALL = "SELECT * FROM groups";
    private final String SQL_FIND_BY_ID = "SELECT * FROM groups WHERE id = ?";
    private final String SQL_SAVE_GROUP = "INSERT INTO groups (number) VALUES (?)";
    private final String SQL_UPDATE_GROUP = "UPDATE groups SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE id = ?";

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
    public int save(Group group) {
        return template.update(SQL_SAVE_GROUP, group.getName());
    }

    @Override
    public int update(Group group) {
        return template.update(SQL_UPDATE_GROUP, group.getName(), group.getId());
    }

    @Override
    public int delete(Integer id) {
        return template.update(SQL_DELETE_GROUP, id);
    }

    @Override
    public List<Group> findAll() {
        return template.query(SQL_FIND_ALL, groupRowMapper);
    }
}