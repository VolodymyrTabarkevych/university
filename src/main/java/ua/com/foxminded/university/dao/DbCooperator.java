package ua.com.foxminded.university.dao;

import javax.sql.DataSource;

import lombok.Getter;

@Getter
public class DbCooperator {
    private TeacherDao teacherDaoJdbcTemplateImpl;
    private StudentDao studentDaoJdbcTemplateImpl;
    private GroupDao groupDaoJdbcTemplateImpl;
    private SubjectDao subjectDaoJdbcTemplateImpl;
    private RoomDao roomDaoJdbcTemplateImpl;
    private LectureDao lectureDaoJdbcTemplateImpl;

    public DbCooperator(DataSource dataSource) {
        this.teacherDaoJdbcTemplateImpl = new TeacherDao(dataSource);
        this.studentDaoJdbcTemplateImpl = new StudentDao(dataSource);
        this.groupDaoJdbcTemplateImpl = new GroupDao(dataSource);
        this.subjectDaoJdbcTemplateImpl = new SubjectDao(dataSource);
        this.roomDaoJdbcTemplateImpl = new RoomDao(dataSource);
        this.lectureDaoJdbcTemplateImpl = new LectureDao(dataSource);
    }
}
