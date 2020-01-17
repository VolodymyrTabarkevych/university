package ua.com.foxminded.university.console;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ua.com.foxminded.university.dao.GroupDaoJdbcTemplateImpl;
import ua.com.foxminded.university.dao.StudentDaoJdbcTemplateImpl;
import ua.com.foxminded.university.dao.SubjectDaoJdbcTemplateImpl;
import ua.com.foxminded.university.dao.TeacherDaoJdbcTemplateImpl;
import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.domain.Student;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;
import ua.com.foxminded.university.domain.University;

class UniversityViewer {
    private TeacherDaoJdbcTemplateImpl teacherDaoJdbcTemplateImpl;
    private StudentDaoJdbcTemplateImpl studentDaoJdbcTemplateImpl;
    private GroupDaoJdbcTemplateImpl groupDaoJdbcTemplateImpl;
    private SubjectDaoJdbcTemplateImpl subjectDaoJdbcTemplateImpl;

    public UniversityViewer(DriverManagerDataSource dataSource) {
        this.teacherDaoJdbcTemplateImpl = new TeacherDaoJdbcTemplateImpl(dataSource);
        this.studentDaoJdbcTemplateImpl = new StudentDaoJdbcTemplateImpl(dataSource);
        this.groupDaoJdbcTemplateImpl = new GroupDaoJdbcTemplateImpl(dataSource);
    }

    public void viewAllTeachers() {
        for (Teacher teacher : teacherDaoJdbcTemplateImpl.findAll()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }

    }

    public void viewAllStudents() {
        for (Student student : studentDaoJdbcTemplateImpl.findAll()) {
            System.out.println(student.getId() + ". " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void viewAllGroups() {
        for (Group group : groupDaoJdbcTemplateImpl.findAll()) {
            System.out.println(group.getName());
        }
    }

    public void viewAllSubjects() {
        for (Subject subject : subjectDaoJdbcTemplateImpl.findAll()) {
            System.out.println(subject.getName());
        }
    }

    public void viewAllRooms() {
        for (Room room : university.getRooms()) {
            System.out.println(room.getNumber());
        }
    }

    public void showAllStudents(Group group) {
        for (Student student : group.getStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }
}
