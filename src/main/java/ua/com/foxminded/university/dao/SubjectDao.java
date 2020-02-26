package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Subject;

public class SubjectDao implements CrudDao<Subject> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM subjects";
    private final String SQL_FIND_BY_ID = "SELECT * FROM subjects WHERE id = ?";
    private final String SQL_SAVE_SUBJECT = "INSERT INTO subjects (name) VALUES (?)";
    private final String SQL_UPDATE_SUBJECT = "UPDATE subjects SET name = ? WHERE id = ?";
    private final String SQL_DELETE_SUBJECT = "DELETE FROM subjects WHERE id = ?";

    public SubjectDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Subject> subjectRowMapper = (ResultSet resultSet, int i) -> {
        Subject subject = new Subject(resultSet.getInt("id"), resultSet.getString("name"));
        return subject;
    };

    @Override
    public Subject find(Integer id) {
        Subject subject = template.query(SQL_FIND_BY_ID, subjectRowMapper, id).get(0);
        if (subject == null) {
            System.out.println("No subject with such id!");
        }
        return subject;
    }

    @Override
    public void save(Subject subject) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_SUBJECT, subject.getName());
        if (rowsAffected > 0) {
            System.out.println("Subject has been added!");
        } else {
            System.out.println("Subject hasn't been added!");
        }

    }

    @Override
    public void update(Subject subject) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_SUBJECT, subject.getName(), subject.getId());
        if (rowsAffected > 0) {
            System.out.println("Info has been updated!");
        } else {
            System.out.println("Info hasn't been updated!");
        }
    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_DELETE_SUBJECT, id);
        if (rowsAffected > 0) {
            System.out.println("Subject has been removed!");
        } else {
            System.out.println("Subject hasn't been removed!");
        }

    }

    @Override
    public List<Subject> findAll() {
        return template.query(SQL_FIND_ALL, subjectRowMapper);
    }

}
