package ua.com.foxminded.university.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.dao.LectureDao;
import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.dao.TeacherDao;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

@Service
public class LectureService {
    private LectureDao lectureDao;
    private RoomDao roomDao;
    private GroupDao groupDao;
    private TeacherDao teacherDao;
    private SubjectDao subjectDao;

    @Autowired
    public LectureService(LectureDao lectureDao, RoomDao roomDao, GroupDao groupDao, TeacherDao teacherDao,
            SubjectDao subjectDao) {
        this.lectureDao = lectureDao;
        this.roomDao = roomDao;
        this.groupDao = groupDao;
        this.teacherDao = teacherDao;
        this.subjectDao = subjectDao;
    }

    public void changeRoom(int lectureId, int roomId) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setRoom(roomDao.find(roomId));
        lectureDao.update(lecture);
    }

    public void changeDate(int lectureId, LocalDate localDate) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setDate(localDate);
        lectureDao.update(lecture);
    }

    public void changeTime(int lectureId, LocalTime startTime, LocalTime endTime) {
        Lecture lecture = lectureDao.find(lectureId);
        lecture.setStartTime(startTime);
        lecture.setEndTime(endTime);
        lectureDao.update(lecture);
    }

    public void changeGroup(int lectureId, int groupId) {
        Lecture lecture = lectureDao.find(lectureId);
        Group group = groupDao.find(groupId);
        lecture.setGroup(group);
        lectureDao.update(lecture);
    }

    public void changeTeacher(int lectureId, int teacherId) {
        Lecture lecture = lectureDao.find(lectureId);
        Teacher teacher = teacherDao.find(teacherId);
        lecture.setTeacher(teacher);
        lectureDao.update(lecture);
    }

    public void changeSubject(int lectureId, int subjectId) {
        Lecture lecture = lectureDao.find(lectureId);
        Subject subject = subjectDao.find(subjectId);
        lecture.setSubject(subject);
        lectureDao.update(lecture);
    }

    public void addLecture(int teacherId, int groupId, int subjectId, int roomId, LocalDate date, LocalTime startTime,
            LocalTime endTime) {
        Lecture lecture = Lecture.builder().teacher(teacherDao.find(teacherId)).group(groupDao.find(groupId))
                .subject(subjectDao.find(subjectId)).room(roomDao.find(roomId)).date(date).startTime(startTime)
                .endTime(endTime).build();
        lectureDao.save(lecture);
    }

    public void removeLecture(Integer lectureId) {
        lectureDao.delete(lectureId);
    }

    public List<Lecture> findAll() {
        return lectureDao.findAll();
    }

}
