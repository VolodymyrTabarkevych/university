package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Student;

public class StudentDaoJdbcTemplateImpl implements CrudDao<Student> {
    private JdbcTemplate template;
    private Map<Integer, Student> students = new HashMap<>();
    private final String SQL_FIND_ALL = "SELECT * FROM students";
    private final String SQL_FIND_BY_ID = "SELECT * FROM students WHERE id = ?";
    private final String SQL_SAVE_STUDENT = "INSERT INTO students (first_name, last_name, group_id) VALUES (?,?,?)";
    private final String SQL_UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ?, group_id = ? WHERE id = ?";
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
        template.query(SQL_FIND_BY_ID, studentRowMapper, id);
        return students.get(id);
    }

    @Override
    public void save(Student student) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_STUDENT, student.getFirstName(), student.getLastName(),
                student.getGroup().getId());
        if (rowsAffected > 0) {
            System.out.println("Student has been added!");
        } else {
            System.out.println("Student hasn't been added!");
        }
    }

    @Override
    public void update(Student student) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_STUDENT, student.getFirstName(), student.getLastName(),
                student.getGroup().getId(), student.getId());
        if (rowsAffected > 0) {
            System.out.println("Info has been updated!");
        } else {
            System.out.println("Info hasn't been updated!");
        }
    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_DELETE_STUDENT, id);
        if (rowsAffected > 0) {
            System.out.println("Student has been removed!");
        } else {
            System.out.println("Student hasn't been removed!");
        }
    }

    @Override
    public List<Student> findAll() {
        return template.query(SQL_FIND_ALL, studentRowMapper);
    }
}
