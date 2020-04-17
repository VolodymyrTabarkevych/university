package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.domain.Subject;

@Repository
public class SubjectDao implements CrudDao<Subject> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM subjects";
    private final String SQL_FIND_BY_ID = "SELECT * FROM subjects WHERE id = ?";
    private final String SQL_SAVE_SUBJECT = "INSERT INTO subjects (name) VALUES (?)";
    private final String SQL_UPDATE_SUBJECT = "UPDATE subjects SET name = ? WHERE id = ?";
    private final String SQL_DELETE_SUBJECT = "DELETE FROM subjects WHERE id = ?";

    @Autowired
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
        return subject;
    }

    @Override
    public int save(Subject subject) {
        return template.update(SQL_SAVE_SUBJECT, subject.getName());
    }

    @Override
    public int update(Subject subject) {
        return template.update(SQL_UPDATE_SUBJECT, subject.getName(), subject.getId());
    }

    @Override
    public int delete(Integer id) {
        return template.update(SQL_DELETE_SUBJECT, id);

    }

    @Override
    public List<Subject> findAll() {
        return template.query(SQL_FIND_ALL, subjectRowMapper);
    }

}
