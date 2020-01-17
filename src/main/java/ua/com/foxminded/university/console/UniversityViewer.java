package ua.com.foxminded.university.console;

import ua.com.foxminded.university.domain.Group;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.domain.Student;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;
import ua.com.foxminded.university.domain.University;

class UniversityViewer {
    University university;

    public UniversityViewer(University university) {
        this.university = university;
        System.out.println("Vse ok!");
    }

    public void viewAllTeachers() {
        System.out.println("Zajshow");
        int i = 0;
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/");
        dataSource.setDriverClassName("org.postgresql.Driver");
        TeacherDaoJdbcTemplateImpl teacherDaoJdbcTemplateImpl = new TeacherDaoJdbcTemplateImpl(dataSource);
        
        for (Teacher teacher : teacherDaoJdbcTemplateImpl.findAll()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
        */
    }

    public void viewAllStudents() {
        for (Student student : university.getStudents()) {
            System.out.println(student.getId() + ". " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void viewAllGroups() {
        for (Group group : university.getGroups()) {
            System.out.println(group.getName());
        }
    }

    public void viewAllSubjects() {
        for (Subject subject : university.getSubjects()) {
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
