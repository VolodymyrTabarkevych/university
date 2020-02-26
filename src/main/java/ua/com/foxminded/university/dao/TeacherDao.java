package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public class TeacherDao implements CrudDao<Teacher> {
    private JdbcTemplate template;
    private final String SQL_SAVE_TEACHER = "INSERT INTO teachers(first_name, last_name) VALUES (?,?)";
    private final String SQL_SAVE_TEACHERS_SUBJECTS = "INSERT INTO teacherssubjects (teacher_id, subject_id) VALUES (?,?)";
    private final String SQL_UPDATE_TEACHER = "UPDATE teachers SET first_name = ? , last_name = ? WHERE id = ?";
    private final String SQL_DELETE_TEACHER = "DELETE FROM teachers WHERE id = ?";
    private final String SQL_FIND_TEACHERS_WITH_SUBJECTS = "SELECT teachers.*, subjects.id as subject_id, subjects.name FROM teacherssubjects INNER JOIN subjects ON subject_id = subjects.id INNER JOIN teachers ON teacher_id = teachers.id";
    private final String SQL_FIND_TEACHER_WITH_SUBJECTS = "SELECT teachers.*, subjects.id as subject_id, subjects.name FROM teacherssubjects INNER JOIN subjects ON subject_id = subjects.id INNER JOIN teachers ON teacher_id = teachers.id WHERE teacher_id = ?";
    private final String SQL_FIND_ALL_SUBJECTS = "SELECT * FROM teachersubjects WHERE teacher_id = ?";

    public TeacherDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Teacher> teacherRowMapperWithSubjects = (ResultSet resultSet, int i) -> {
        Teacher teacher = new Teacher(resultSet.getInt("id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"));
        Subject subject = new Subject(resultSet.getInt("subject_id"), resultSet.getString("name"));
        subject.getTeachers().add(teacher);
        teacher.addSubject(subject);
        return teacher;
    };

    @Override
    public Teacher find(Integer teacherId) {
        Teacher teacher = template.query(SQL_FIND_TEACHER_WITH_SUBJECTS, teacherRowMapperWithSubjects, teacherId)
                .get(0);
        if (teacher == null) {
            System.out.println("No teacher with such id!");
        }
        return teacher;
    }

    @Override
    public void save(Teacher teacher) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_TEACHER, teacher.getFirstName(), teacher.getLastName());
        if (!teacher.getSubjects().isEmpty()) {
            for (Subject subject : teacher.getSubjects()) {
                template.update(SQL_SAVE_TEACHERS_SUBJECTS, teacher.getId(), subject.getId());
            }
        }
        if (rowsAffected > 0) {
            System.out.println("Teacher has been added!");
        } else {
            System.out.println("Teacher hasn't been added!");
        }
    }

    @Override
    public void update(Teacher teacher) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_TEACHER, teacher.getFirstName(), teacher.getLastName(),
                teacher.getId());
        if (rowsAffected > 0) {
            System.out.println("Data has been updated!");
        } else {
            System.out.println("No teacher with such id!");
        }

    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_DELETE_TEACHER, id);
        if (rowsAffected > 0) {
            System.out.println("Teacher has been removed!");
        } else {
            System.out.println("No teacher with such id!");
        }
    }

    @Override
    public List<Teacher> findAll() {
        return template.query(SQL_FIND_TEACHERS_WITH_SUBJECTS, teacherRowMapperWithSubjects);
    }

    public Teacher findAllSubjects(Integer teacherId) {
        Teacher teacher = template.query(SQL_FIND_ALL_SUBJECTS, teacherRowMapperWithSubjects, teacherId).get(0);
        if (teacher == null) {
            System.out.println("No teacher with such id!");
        }
        return teacher;
    }
}
