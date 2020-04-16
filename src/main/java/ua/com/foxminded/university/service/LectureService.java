package ua.com.foxminded.university.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.dao.LectureDao;
import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.dao.TeacherDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public class LectureService {
    private LectureDao lectureDao;
    private RoomDao roomDao;
    private GroupDao groupDao;
    private TeacherDao teacherDao;
    private SubjectDao subjectDao;

    public LectureService(DataSource dataSource) {
        this.lectureDao = new LectureDao(dataSource);
        this.roomDao = new RoomDao(dataSource);
        this.groupDao = new GroupDao(dataSource);
        this.teacherDao = new TeacherDao(dataSource);
        this.subjectDao = new SubjectDao(dataSource);
    }

    public int changeRoom(int lectureId, int roomId) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setRoom(roomDao.find(roomId));
        return lectureDao.update(lecture);
    }

    public int changeDate(int lectureId, LocalDate localDate) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setDate(localDate);
        return lectureDao.update(lecture);
    }

    public int changeTime(int lectureId, LocalTime startTime, LocalTime endTime) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setStartTime(startTime);
        lecture.setEndTime(endTime);
        return lectureDao.update(lecture);
    }

    public int changeGroup(int lectureId, int groupId) {
        Lecture lecture = lectureDao.find(lectureId);
        Group group = groupDao.find(groupId);
        lecture.setGroup(group);
        return lectureDao.update(lecture);
    }

    public int changeTeacher(int lectureId, int teacherId) {
        Lecture lecture = lectureDao.find(lectureId);
        Teacher teacher = teacherDao.find(teacherId);
        lecture.setTeacher(teacher);
        return lectureDao.update(lecture);
    }

    public int changeSubject(int lectureId, int subjectId) {
        Lecture lecture = lectureDao.find(lectureId);
        Subject subject = subjectDao.find(subjectId);
        lecture.setSubject(subject);
        return lectureDao.update(lecture);
    }

    public int addLecture(int teacherId, int groupId, int subjectId, int roomId, LocalDate date, LocalTime startTime,
            LocalTime endTime) {
        Lecture lecture = new Lecture.Builder().setTeacher(teacherDao.find(teacherId)).setGroup(groupDao.find(groupId))
                .setSubject(subjectDao.find(subjectId)).setRoom(roomDao.find(roomId)).setDate(date)
                .setStartTime(startTime).setEndTime(endTime).build();
        return lectureDao.save(lecture);
    }

    public int removeLecture(Integer lectureId) {
        return lectureDao.delete(lectureId);
    }

    public List<Lecture> findAll() {
        return lectureDao.findAll();
    }

}
