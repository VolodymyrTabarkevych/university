package ua.com.foxminded.university;

import javax.sql.DataSource;

import lombok.Getter;
import ua.com.foxminded.university.dao.GroupDao;
import ua.com.foxminded.university.dao.LectureDao;
import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.dao.StudentDao;
import ua.com.foxminded.university.dao.SubjectDao;
import ua.com.foxminded.university.dao.TeacherDao;

@Getter
public class DbCooperator {
    private TeacherDao teacherDao;
    private StudentDao studentDao;
    private GroupDao groupDao;
    private SubjectDao subjectDao;
    private RoomDao roomDao;
    private LectureDao lectureDao;

    public DbCooperator(DataSource dataSource) {
        this.teacherDao = new TeacherDao(dataSource);
        this.studentDao = new StudentDao(dataSource);
        this.groupDao = new GroupDao(dataSource);
        this.subjectDao = new SubjectDao(dataSource);
        this.roomDao = new RoomDao(dataSource);
        this.lectureDao = new LectureDao(dataSource);
    }
}
