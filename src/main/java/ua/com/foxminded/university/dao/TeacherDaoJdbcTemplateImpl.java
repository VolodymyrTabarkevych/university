package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Teacher;

public class TeacherDaoJdbcTemplateImpl implements TeacherDao {
    private JdbcTemplate template;
    private final String SQL_SELECT_ALL = "SELECT * FROM teachers";

    public TeacherDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Teacher> teacherRowMapper = (ResultSet resultSet, int i) -> {
        return new Teacher(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
    };

    @Override
    public Teacher find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Teacher model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Teacher model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Teacher> findAll() {
        return template.query(SQL_SELECT_ALL, teacherRowMapper);
    }

}
