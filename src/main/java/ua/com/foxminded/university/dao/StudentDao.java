package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.models.Group;
import ua.com.foxminded.university.models.Student;

@Repository
public class StudentDao implements CrudDao<Student> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT students.id, first_name, last_name, groups.id as group_id, groups.name as group_name FROM students INNER JOIN groups ON group_id = groups.id";
    private final String SQL_FIND_BY_ID = "SELECT students.id, first_name, last_name, groups.id as group_id, groups.name as group_name FROM students INNER JOIN groups ON group_id = groups.id WHERE students.id = ?";
    private final String SQL_SAVE_STUDENT = "INSERT INTO students (first_name, last_name, group_id) VALUES (?,?,?)";
    private final String SQL_UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ?, group_id = ? WHERE id = ?";
    private final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private final String SQL_FIND_STUDENTS_BY_GROUP_ID = "SELECT students.id, first_name, last_name, groups.id as group_id, groups.name as group_name FROM students INNER JOIN groups ON group_id = groups.id WHERE group_id = ?";

    @Autowired
    public StudentDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Student> studentRowMapper = (ResultSet resultSet, int i) -> {
        Student student = new Student(resultSet.getInt("id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                Group.builder().id(resultSet.getInt("group_id")).name(resultSet.getString("group_name")).build());
        return student;
    };

    @Override
    public Student find(Integer id) {
        Student student = template.query(SQL_FIND_BY_ID, studentRowMapper, id).get(0);
        return student;
    }

    @Override
    public void save(Student student) {
        template.update(SQL_SAVE_STUDENT, student.getFirstName(), student.getLastName(), student.getGroup().getId());
    }

    @Override
    public void update(Student student) {
        template.update(SQL_UPDATE_STUDENT, student.getFirstName(), student.getLastName(), student.getGroup().getId(),
                student.getId());
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_STUDENT, id);
    }

    @Override
    public List<Student> findAll() {
        return template.query(SQL_FIND_ALL, studentRowMapper);
    }

    public List<Student> findAllByGroupId(Integer groupId) {
        return template.query(SQL_FIND_STUDENTS_BY_GROUP_ID, studentRowMapper, groupId);
    }
}
