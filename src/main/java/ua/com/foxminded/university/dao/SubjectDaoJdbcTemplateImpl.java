package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Subject;

public class SubjectDaoJdbcTemplateImpl implements SubjectDao {
    private JdbcTemplate template;
    private final String SQL_SELECT_ALL = "SELECT * FROM subjects";
    private final String SQL_SAVE_SUBJECT = "INSERT INTO subjects (name) VALUES (?)";

    public SubjectDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Subject> subjectRowMapper = (ResultSet resultSet, int i) -> {
        return new Subject(resultSet.getString("name"));
    };

    @Override
    public Subject find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Subject subject) {
        template.update(SQL_SAVE_SUBJECT, subject.getName());

    }

    @Override
    public void update(Subject model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Subject> findAll() {
        return template.query(SQL_SELECT_ALL, subjectRowMapper);
    }

}
