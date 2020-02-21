package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public class LectureDaoJdbcTemplateImpl implements CrudDao<Lecture> {
    private JdbcTemplate template;
    private Map<Integer, Lecture> lectures = new HashMap<>();
    private final String SQL_FIND_ALL = "SELECT lecture_id, teachers.first_name, teachers.last_name, groups.name as group_name, subjects.name as subject_name, rooms.number as room_number, lecture_begin, lecture_end FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id";
    private final String SQL_FIND_BY_ID = "SELECT * FROM lectures WHERE id = ?";
    private final String SQL_SAVE_LECTURE = "INSERT INTO lectures (teacher_id, group_id, subject_id,room_id,lecture_begin, lecture_end) VALUES (?,?,?,?,?,?)";
    private final String SQL_UPDATE_LECTURES = "UPDATE lectures SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_LECTURES = "DELETE FROM lectures WHERE id = ?";

    public LectureDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Lecture> lectureRowMapper = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("lecture_id");
        if (!lectures.containsKey(id)) {
            Lecture lecture = new Lecture().setLectureId(resultSet.getInt("lecture_id"))
                    .setTeacher(new Teacher(resultSet.getString("first_name"), resultSet.getString("last_name")))
                    .setGroup(new Group(resultSet.getString("group_name")))
                    .setSubject(new Subject(resultSet.getString("subject_name")))
                    .setRoom(new Room(resultSet.getInt("room_number")))
                    .setDateTimeBegin(resultSet.getTimestamp("lecture_begin"))
                    .setDateTimeEnd(resultSet.getTimestamp("lecture_end")).build();
            lectures.put(id, lecture);
        }
        return lectures.get(id);
    };

    @Override
    public Lecture find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Lecture lecture) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_LECTURE, lecture.getTeacher().getId(), lecture.getGroup().getId(),
                lecture.getSubject().getId(), lecture.getRoom().getId(), lecture.getLectureBegin(),
                lecture.getLectureEnd());
        if (rowsAffected > 0) {
            System.out.println("Lecture has been added!");
        } else {
            System.out.println("Lecture hasn't been added!");
        }
    }

    @Override
    public void update(Lecture model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Lecture> findAll() {
        return template.query(SQL_FIND_ALL, lectureRowMapper);
    }

}
