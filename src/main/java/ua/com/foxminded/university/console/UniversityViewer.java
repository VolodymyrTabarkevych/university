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
    }

    public void viewAllTeachers() {
        for (Teacher teacher : university.getTeachers()) {
            System.out.println(teacher.getId() + ". " + teacher.getFirstName() + " " + teacher.getLastName());
        }
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
