package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Student;

public class GroupDaoJdbcTemplateImpl implements CrudDao<Group> {
    private JdbcTemplate template;
    private Map<Integer, Group> groups = new HashMap<>();
    private final String SQL_FIND_ALL = "SELECT * FROM groups";
    private final String SQL_FIND_BY_ID = "SELECT * FROM groups WHERE id = ?";
    private final String SQL_FIND_STUDENTS_BY_GROUP_ID = "SELECT * FROM students WHERE group_id = ?";
    private final String SQL_SAVE_GROUP = "INSERT INTO groups (number) VALUES (?)";
    private final String SQL_UPDATE_GROUP = "UPDATE groups SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE id = ?";

    public GroupDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Group> groupRowMapper = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");
        if (!groups.containsKey(id)) {
            Group group = new Group(resultSet.getInt("id"), resultSet.getString("name"));
            groups.put(id, group);
        }
        return groups.get(id);
    };

    @Override
    public Group find(Integer id) {
        template.query(SQL_FIND_BY_ID, groupRowMapper, id);
        return groups.get(id);
    }

    @Override
    public void save(Group group) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_GROUP, group.getName());
        if (rowsAffected > 0) {
            System.out.println("Group has been added!");
        } else {
            System.out.println("Group hasn't been added!");
        }
    }

    @Override
    public void update(Group group) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_GROUP, group.getName(), group.getId());
        if (rowsAffected > 0) {
            System.out.println("Info has been updated!");
        } else {
            System.out.println("Ifno hasn't been updated!");
        }
    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_DELETE_GROUP, id);
        if (rowsAffected > 0) {
            System.out.println("Group has been removed!");
        } else {
            System.out.println("Group hasn't been removed!");
        }
    }

    @Override
    public List<Group> findAll() {
        return template.query(SQL_FIND_ALL, groupRowMapper);
    }
}
