package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.models.Lecture;
import ua.com.foxminded.university.models.Room;
import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.models.Teacher;

@Repository
public class LectureDao implements CrudDao<Lecture> {
    private JdbcTemplate template;
    private GroupDao groupDaoJdbcTemplateImpl;
    private final String SQL_FIND_ALL_WITH_DATA = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id";
    private final String SQL_FIND_BY_ID = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE lecture_id = ?";
    private final String SQL_FIND_ALL_LECTURES_BY_GROUP_ID_AND_DAY = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE group_id = ? AND date = ?";
    private final String SQL_FIND_ALL_LECTURES_BY_GROUP_ID_AND_MONTH = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE group_id = ? AND EXTRACT(YEAR FROM date) = ? AND EXTRACT(MONTH FROM date) = ?";
    private final String SQL_FIND_ALL_LECTURES_BY_TEACHER_ID_AND_DAY = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE teacher_id = ? AND date = ?";
    private final String SQL_FIND_ALL_LECTURES_BY_TEACHER_ID_AND_MONTH = "SELECT lecture_id, teachers.id as teacher_id, teachers.first_name, teachers.last_name, groups.id as group_id, groups.name as group_name, subjects.id as subject_id, subjects.name as subject_name, rooms.id as room_id, rooms.number as room_number, date, start_time, end_time FROM lectures INNER JOIN teachers ON teacher_id = teachers.id INNER JOIN groups ON group_id = groups.id INNER JOIN subjects ON subject_id = subjects.id INNER JOIN rooms ON room_id = rooms.id WHERE teacher_id = ? AND EXTRACT(YEAR FROM date) = ? AND EXTRACT(MONTH FROM date) = ?";
    private final String SQL_SAVE_LECTURE = "INSERT INTO lectures (teacher_id, group_id, subject_id,room_id, date, start_time, end_time) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE_LECTURE = "UPDATE lectures SET teacher_id = ?, group_id = ?, subject_id = ?, room_id = ?, date = ?, start_time = ?, end_time = ? WHERE lecture_id = ?";
    private final String SQL_DELETE_LECTURE = "DELETE FROM lectures WHERE lecture_id = ?";

    @Autowired
    public LectureDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        groupDaoJdbcTemplateImpl = new GroupDao(dataSource);
    }

    private RowMapper<Lecture> lectureRowMapper = (ResultSet resultSet, int i) -> {
        Lecture lecture = Lecture.builder().lectureId(resultSet.getInt("lecture_id"))
                .teacher(Teacher
                        .builder().id(resultSet.getInt("teacher_id")).firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name")).build())
                .group(groupDaoJdbcTemplateImpl.find(resultSet.getInt("group_id")))
                .subject(Subject.builder().id(resultSet.getInt("subject_id")).name(resultSet.getString("subject_name"))
                        .build())
                .room(new Room(resultSet.getInt("room_id"), resultSet.getInt("room_number")))
                .date(resultSet.getDate("date").toLocalDate()).startTime(resultSet.getTime("start_time").toLocalTime())
                .endTime(resultSet.getTime("end_time").toLocalTime()).build();
        return lecture;
    };

    @Override
    public Lecture find(Integer id) {
        Lecture lecture = template.query(SQL_FIND_BY_ID, lectureRowMapper, id).get(0);
        return lecture;
    }

    @Override
    public void save(Lecture lecture) {
        template.update(SQL_SAVE_LECTURE, lecture.getTeacher().getId(), lecture.getGroup().getId(),
                lecture.getSubject().getId(), lecture.getRoom().getId(), lecture.getDate(), lecture.getStartTime(),
                lecture.getEndTime());
    }

    @Override
    public void update(Lecture lecture) {
        template.update(SQL_UPDATE_LECTURE, lecture.getTeacher().getId(), lecture.getGroup().getId(),
                lecture.getSubject().getId(), lecture.getRoom().getId(), lecture.getDate(), lecture.getStartTime(),
                lecture.getEndTime(), lecture.getLectureId());
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_LECTURE, id);
    }

    @Override
    public List<Lecture> findAll() {
        return template.query(SQL_FIND_ALL_WITH_DATA, lectureRowMapper);
    }

    public List<Lecture> findAllLecturesByGroupIdAndDay(int groupId, LocalDate date) {
        return template.query(SQL_FIND_ALL_LECTURES_BY_GROUP_ID_AND_DAY, lectureRowMapper, groupId, date);
    }

    public List<Lecture> findAllLecturesByGroupIdAndMonth(int groupId, LocalDate date) {
        return template.query(SQL_FIND_ALL_LECTURES_BY_GROUP_ID_AND_MONTH, lectureRowMapper, groupId, date.getYear(),
                date.getMonthValue());
    }

    public List<Lecture> findAllLecturesByTeacherIdAndDay(int teacherId, LocalDate date) {
        return template.query(SQL_FIND_ALL_LECTURES_BY_TEACHER_ID_AND_DAY, lectureRowMapper, teacherId, date);
    }

    public List<Lecture> findAllLecturesByTeacherIdAndMonth(int teacherId, LocalDate date) {
        return template.query(SQL_FIND_ALL_LECTURES_BY_TEACHER_ID_AND_MONTH, lectureRowMapper, teacherId,
                date.getYear(), date.getMonthValue());
    }

}
