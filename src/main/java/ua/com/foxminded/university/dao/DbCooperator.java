package ua.com.foxminded.university.dao;

import javax.sql.DataSource;

import lombok.Getter;

@Getter
public class DbCooperator {
    private TeacherDaoJdbcTemplateImpl teacherDaoJdbcTemplateImpl;
    private StudentDaoJdbcTemplateImpl studentDaoJdbcTemplateImpl;
    private GroupDaoJdbcTemplateImpl groupDaoJdbcTemplateImpl;
    private SubjectDaoJdbcTemplateImpl subjectDaoJdbcTemplateImpl;
    private RoomDaoJdbcTemplateImpl roomDaoJdbcTemplateImpl;

    public DbCooperator(DataSource dataSource) {
        this.teacherDaoJdbcTemplateImpl = new TeacherDaoJdbcTemplateImpl(dataSource);
        this.studentDaoJdbcTemplateImpl = new StudentDaoJdbcTemplateImpl(dataSource);
        this.groupDaoJdbcTemplateImpl = new GroupDaoJdbcTemplateImpl(dataSource);
        this.subjectDaoJdbcTemplateImpl = new SubjectDaoJdbcTemplateImpl(dataSource);
        this.roomDaoJdbcTemplateImpl = new RoomDaoJdbcTemplateImpl(dataSource);
    }
}
