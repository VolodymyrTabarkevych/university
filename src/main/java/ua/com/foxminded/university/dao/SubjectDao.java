package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.models.Subject;

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
        Subject subject = Subject.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build();
        return subject;
    };

    @Override
    public Subject find(Integer id) {
        Subject subject = template.query(SQL_FIND_BY_ID, subjectRowMapper, id).get(0);
        return subject;
    }

    @Override
    public void save(Subject subject) {
        template.update(SQL_SAVE_SUBJECT, subject.getName());
    }

    @Override
    public void update(Subject subject) {
        template.update(SQL_UPDATE_SUBJECT, subject.getName(), subject.getId());
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_SUBJECT, id);

    }

    @Override
    public List<Subject> findAll() {
        return template.query(SQL_FIND_ALL, subjectRowMapper);
    }

}
