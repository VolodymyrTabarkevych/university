package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Student;

public class StudentDaoJdbcTemplateImpl implements StudentDao {
    private JdbcTemplate template;
    private final String SQL_SELECT_ALL = "SELECT * FROM students";

    public StudentDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Student> studentRowMapper = (ResultSet resultSet, int i) -> {
        return new Student(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
    };

    @Override
    public Student find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Student model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Student model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Student> findAll() {
        return template.query(SQL_SELECT_ALL, studentRowMapper);
    }

    @Override
    public void getGroup() {
        // TODO Auto-generated method stub

    }

}
