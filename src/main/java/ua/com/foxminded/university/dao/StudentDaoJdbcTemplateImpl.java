package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Student;

public class StudentDaoJdbcTemplateImpl implements StudentDao {
    private JdbcTemplate template;
    private Map<Integer, Student> students = new HashMap<>();
    private final String SQL_FIND_ALL = "SELECT * FROM students";
    private final String SQL_FIND_BY_ID = "SELECT * FROM students WHERE id = ?";
    private final String SQL_SAVE_STUDENT = "INSERT INTO students (first_name, last_name) VALUES (?,?)";
    private final String SQL_UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ? WHERE id = ?";
    private final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE id = ?";

    public StudentDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Student> studentRowMapper = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");
        if (!students.containsKey(id)) {
            Student student = new Student(resultSet.getInt("id"), resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
            students.put(id, student);
        }
        return students.get(id);
    };

    @Override
    public Student find(Integer id) {
        template.update(SQL_FIND_BY_ID, studentRowMapper, id);
        return students.get(id);
    }

    @Override
    public void save(Student student) {
        template.update(SQL_SAVE_STUDENT, student.getFirstName(), student.getLastName(), student.getGroup().getId());

    }

    @Override
    public void update(Student student) {
        template.update(SQL_UPDATE_STUDENT, student.getFirstName(), student.getLastName(), student.getId());

    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_STUDENT, id);

    }

    @Override
    public List<Student> findAll() {
        return template.query(SQL_FIND_ALL, studentRowMapper);
    }

    @Override
    public void getGroup() {
        // TODO Auto-generated method stub

    }

}
