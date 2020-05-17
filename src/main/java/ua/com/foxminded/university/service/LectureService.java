package ua.com.foxminded.university.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.models.Group;
import ua.com.foxminded.university.models.Lecture;
import ua.com.foxminded.university.models.Subject;
import ua.com.foxminded.university.models.Teacher;
import ua.com.foxminded.university.repositories.GroupsRepository;
import ua.com.foxminded.university.repositories.LectureRepository;
import ua.com.foxminded.university.repositories.RoomsRepository;
import ua.com.foxminded.university.repositories.SubjectsRepository;
import ua.com.foxminded.university.repositories.TeachersRepository;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private SubjectsRepository subjectsRepository;

    public void changeRoom(int lectureId, int roomId) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        lecture.setRoom(roomsRepository.findById(roomId).get());
        lectureRepository.save(lecture);
    }

    public void changeDate(int lectureId, LocalDate localDate) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        lecture.setDate(localDate);
        lectureRepository.save(lecture);
    }

    public void changeTime(int lectureId, LocalTime startTime, LocalTime endTime) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        lecture.setStartTime(startTime);
        lecture.setEndTime(endTime);
        lectureRepository.save(lecture);
    }

    public void changeGroup(int lectureId, int groupId) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        Group group = groupsRepository.findById(groupId).get();
        lecture.setGroup(group);
        lectureRepository.save(lecture);
    }

    public void changeTeacher(int lectureId, int teacherId) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        Teacher teacher = teachersRepository.findById(teacherId).get();
        lecture.setTeacher(teacher);
        lectureRepository.save(lecture);
    }

    public void changeSubject(int lectureId, int subjectId) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        Subject subject = subjectsRepository.findById(subjectId).get();
        lecture.setSubject(subject);
        lectureRepository.save(lecture);
    }

    public void addLecture(int teacherId, int groupId, int subjectId, int roomId, LocalDate date, LocalTime startTime,
            LocalTime endTime) {
        Lecture lecture = Lecture.builder().teacher(teachersRepository.findById(teacherId).get())
                .group(groupsRepository.findById(groupId).get()).subject(subjectsRepository.findById(subjectId).get())
                .room(roomsRepository.findById(roomId).get()).date(date).startTime(startTime).endTime(endTime).build();
        lectureRepository.save(lecture);
    }

    public void removeLecture(Integer lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    public List<Lecture> viewAllLectures() {
        return lectureRepository.findAll();
    }

}
