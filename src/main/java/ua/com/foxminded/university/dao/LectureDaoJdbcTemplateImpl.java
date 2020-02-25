package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public class LectureDaoJdbcTemplateImpl implements CrudDao<Lecture> {
    private JdbcTemplate template;
    private GroupDaoJdbcTemplateImpl groupDaoJdbcTemplateImpl;
    private Map<Integer, Lecture> lectures = new HashMap<>();
    // private final String SQL_FIND_ALL = "SELECT * FROM lectures";
    private final String SQL_FIND_ALL_WITH_DATA = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id";
    private final String SQL_FIND_BY_ID = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE lecture_id = ?";
    private final String SQL_FING_ALL_LECTURES_BY_GROUP_ID = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE group_id = ?";
    private final String SQL_SAVE_LECTURE = "INSERT INTO lectures (teacher_id, group_id, subject_id,room_id, date, start_time, end_time) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE_LECTURE = "UPDATE lectures SET teacher_id = ?, group_id = ?, subject_id = ?, room_id = ?, date = ?, start_time = ?, end_time = ? WHERE lecture_id = ?";
    private final String SQL_DELETE_LECTURE = "DELETE FROM lectures WHERE lecture_id = ?";

    public LectureDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        groupDaoJdbcTemplateImpl = new GroupDaoJdbcTemplateImpl(dataSource);
    }

    private RowMapper<Lecture> lectureRowMapper = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("lecture_id");
        if (!lectures.containsKey(id)) {
            Lecture lecture = new Lecture.Builder().setLectureId(resultSet.getInt("lecture_id"))
                    .setTeacher(new Teacher(resultSet.getInt("teacher_id"), resultSet.getString("first_name"),
                            resultSet.getString("last_name")))
                    .setGroup(groupDaoJdbcTemplateImpl.find(resultSet.getInt("group_id")))
                    .setSubject(new Subject(resultSet.getInt("subject_id"), resultSet.getString("subject_name")))
                    .setRoom(new Room(resultSet.getInt("room_id"), resultSet.getInt("room_number")))
                    .setDate(resultSet.getDate("date").toLocalDate())
                    .setStartTime(resultSet.getTime("start_time").toLocalTime())
                    .setEndTime(resultSet.getTime("end_time").toLocalTime()).build();
            lectures.put(id, lecture);
        }
        return lectures.get(id);
    };

    @Override
    public Lecture find(Integer id) {
        template.query(SQL_FIND_BY_ID, lectureRowMapper, id);
        return lectures.get(id);
    }

    public List<Lecture> findAllLecturesByGroupId(int groupId) {
        return template.query(SQL_FING_ALL_LECTURES_BY_GROUP_ID, lectureRowMapper, groupId);
    }

    @Override
    public void save(Lecture lecture) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_LECTURE, lecture.getTeacher().getId(), lecture.getGroup().getId(),
                lecture.getSubject().getId(), lecture.getRoom().getId(), lecture.getDate(), lecture.getStartTime(),
                lecture.getEndTime());
        if (rowsAffected > 0) {
            System.out.println("Lecture has been added!");
        } else {
            System.out.println("Lecture hasn't been added!");
        }
    }

    @Override
    public void update(Lecture lecture) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_LECTURE, lecture.getTeacher().getId(), lecture.getGroup().getId(),
                lecture.getSubject().getId(), lecture.getRoom().getId(), lecture.getDate(), lecture.getStartTime(),
                lecture.getEndTime(), lecture.getLectureId());
        if (rowsAffected > 0) {
            System.out.println("Lecture has been updated!");
        } else {
            System.out.println("Lecture hasn't been updated!");
        }
    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        template.update(SQL_DELETE_LECTURE, id);
        if (rowsAffected > 0) {
            System.out.println("Lecture has been deleted!");
        } else {
            System.out.println("Lecture hasn't been deleted!");
        }
    }

    @Override
    public List<Lecture> findAll() {
        return template.query(SQL_FIND_ALL_WITH_DATA, lectureRowMapper);
    }

}
