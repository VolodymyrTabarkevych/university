package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.models.Teacher;

@Repository
public class TeacherDao implements CrudDao<Teacher> {
    private JdbcTemplate template;
    private final String SQL_SAVE_TEACHER = "INSERT INTO teachers(first_name, last_name) VALUES (?,?)";
    private final String SQL_SAVE_TEACHERS_SUBJECTS = "INSERT INTO teacherssubjects (teacher_id, subject_id) VALUES (?,?)";
    private final String SQL_UPDATE_TEACHER = "UPDATE teachers SET first_name = ? , last_name = ? WHERE id = ?";
    private final String SQL_DELETE_TEACHER = "DELETE FROM teachers WHERE id = ?";
    private final String SQL_FIND_TEACHERS = "SELECT * FROM teachers";
    private final String SQL_FIND_TEACHER = "SELECT * FROM teachers WHERE id = ?";
    private final String SQL_FIND_ALL_SUBJECTS = "SELECT subject_id, name FROM teacherssubjects INNER JOIN subjects ON subject_id = subjects.id WHERE teacher_id = ?";

    @Autowired
    public TeacherDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Teacher> teacherRowMapperWithSubjects = (ResultSet resultSet, int i) -> {
        Teacher teacher = Teacher.builder().id(resultSet.getInt("id")).firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name")).build();
        teacher.setSubjects(new HashSet<Subject>(findAllSubjects(teacher.getId())));
        return teacher;
    };
    private RowMapper<Subject> subjectRowMapper = (ResultSet resultSet, int i) -> {
        Subject subject = Subject.builder().id(resultSet.getInt("subject_id")).name(resultSet.getString("name"))
                .build();
        return subject;
    };

    @Override
    public Teacher find(Integer teacherId) {
        Teacher teacher = template.query(SQL_FIND_TEACHER, teacherRowMapperWithSubjects, teacherId).get(0);
        return teacher;
    }

    @Override
    public void save(Teacher teacher) {
        template.update(SQL_SAVE_TEACHER, teacher.getFirstName(), teacher.getLastName());
        if (!teacher.getSubjects().isEmpty()) {
            for (Subject subject : teacher.getSubjects()) {
                template.update(SQL_SAVE_TEACHERS_SUBJECTS, teacher.getId(), subject.getId());
            }
        }
    }

    @Override
    public void update(Teacher teacher) {
        template.update(SQL_UPDATE_TEACHER, teacher.getFirstName(), teacher.getLastName(), teacher.getId());
        List<Subject> subjectsFromDatabase = template.query(SQL_FIND_ALL_SUBJECTS, subjectRowMapper, teacher.getId());
        Set<String> subjectsNames = new HashSet<>();
        for (Subject subject : subjectsFromDatabase) {
            subjectsNames.add(subject.getName());
        }
        for (Subject subject : teacher.getSubjects()) {
            if (!subjectsNames.contains(subject.getName())) {
                template.update(SQL_SAVE_TEACHERS_SUBJECTS, teacher.getId(), subject.getId());
            }
        }
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_TEACHER, id);
    }

    @Override
    public List<Teacher> findAll() {
        return template.query(SQL_FIND_TEACHERS, teacherRowMapperWithSubjects);
    }

    public List<Subject> findAllSubjects(Integer teacherId) {
        return template.query(SQL_FIND_ALL_SUBJECTS, subjectRowMapper, teacherId);
    }
}
