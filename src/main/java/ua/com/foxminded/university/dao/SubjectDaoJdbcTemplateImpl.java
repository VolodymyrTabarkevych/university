package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Subject;

public class SubjectDaoJdbcTemplateImpl implements SubjectDao {
    private JdbcTemplate template;
    private Map<Integer, Subject> subjects = new HashMap<>();
    private final String SQL_FIND_ALL = "SELECT * FROM subjects";
    private final String SQL_FIND_BY_ID = "SELECT * FROM subjects WHERE id = ?";
    private final String SQL_SAVE_SUBJECT = "INSERT INTO subjects (name) VALUES (?)";
    private final String SQL_UPDATE_SUBJECT = "UPDATE subjects SET name = ? WHERE id = ?";
    private final String SQL_DELETE_SUBJECT = "DELETE FROM subjects WHERE id = ?";

    public SubjectDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Subject> subjectRowMapper = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");
        if (!subjects.containsKey(id)) {
            Subject subject = new Subject(resultSet.getInt("id"), resultSet.getString("name"));
            subjects.put(id, subject);
        }
        return subjects.get(id);
    };

    @Override
    public Subject find(Integer id) {
        template.query(SQL_FIND_BY_ID, subjectRowMapper, id);
        return subjects.get(id);
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
