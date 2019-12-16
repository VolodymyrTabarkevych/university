package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

public class TestDataForUniversity {
    public University university;

    public TestDataForUniversity(University university) {
        this.university = university;
    }

    public void createDataForUniversity() {
        createTeachers();
        createGroupsAndStudents();
        creatRooms();
        createSubjects();
        createLectures();
    }

    private void createTeachers() {
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(new Teacher(1, "Yaroslav", "Boyko"));
        teachers.add(new Teacher(2, "Genadij", "Lipko"));
        teachers.add(new Teacher(3, "Petro", "Homyak"));
        teachers.add(new Teacher(4, "Vasya", "Polkin"));
        teachers.add(new Teacher(5, "Oleksandr", "Malov"));
        university.setTeachers(teachers);
    }

    private void createGroupsAndStudents() {
        Finder finder;
        Set<Student> students = new HashSet<>();
        Set<Group> groups = new HashSet<>();
        groups.add(new Group("MB - 1"));
        groups.add(new Group("MB - 2"));
        groups.add(new Group("MB - 3"));
        groups.add(new Group("MB - 4"));
        groups.add(new Group("MB - 5"));
        university.setGroups(groups);
        students.add(new Student(1, "Mark", "Globa"));
        students.add(new Student(2, "Denis", "Morkovich"));
        students.add(new Student(3, "Ilya", "Ironovich"));
        students.add(new Student(4, "Olga", "Smirnova"));
        students.add(new Student(5, "Ruslan", "Nebritij"));
        students.add(new Student(6, "Roman", "Pobritij"));
        students.add(new Student(7, "Illarion", "Pomityj"));
        students.add(new Student(8, "Vladislav", "Dolgov"));
        students.add(new Student(9, "Yana", "Khorolska"));
        students.add(new Student(10, "Olga", "Danilec"));
        university.setStudents(students);
        finder = new Finder(university);
        finder.findGroupByName("MB - 1").addStudent(finder.findStudentById(1));
        finder.findGroupByName("MB - 1").addStudent(finder.findStudentById(2));
        finder.findGroupByName("MB - 2").addStudent(finder.findStudentById(3));
        finder.findGroupByName("MB - 2").addStudent(finder.findStudentById(4));
        finder.findGroupByName("MB - 3").addStudent(finder.findStudentById(5));
        finder.findGroupByName("MB - 3").addStudent(finder.findStudentById(6));
        finder.findGroupByName("MB - 4").addStudent(finder.findStudentById(7));
        finder.findGroupByName("MB - 4").addStudent(finder.findStudentById(8));
        finder.findGroupByName("MB - 5").addStudent(finder.findStudentById(9));
        finder.findGroupByName("MB - 5").addStudent(finder.findStudentById(10));
        university.setGroups(groups);
    }

    public void creatRooms() {
        Set<Room> rooms = new HashSet<>();
        rooms.add(new Room(101));
        rooms.add(new Room(102));
        rooms.add(new Room(103));
        rooms.add(new Room(104));
        rooms.add(new Room(105));
        university.setRooms(rooms);
    }

    public void createSubjects() {
        Set<Subject> subjects = new HashSet<>();
        subjects.add(new Subject("Math"));
        subjects.add(new Subject("Biology"));
        subjects.add(new Subject("English"));
        subjects.add(new Subject("History"));
        subjects.add(new Subject("Chemistry"));
        university.setSubjects(subjects);
    }

    private void createLectures() {
        Finder finder = new Finder(university);

        university.getTimetable().addLecture(
                new Lecture().setDate(new LectureDate(2019, 6, 10)).setSubject(finder.findSubjectByName("Math"))
                        .setGroup(finder.findGroupByName("MB - 1")).setTeacher(finder.findTeacherById(1))
                        .setRoom(finder.findRoomByNumber(101)).setTime(new LectureTime(10, 50)));
        university.getTimetable()
                .addLecture(new Lecture().setDate(new LectureDate(2019, 6, 11))
                        .setSubject(finder.findSubjectByName("Biology")).setGroup(finder.findGroupByName("MB - 1"))
                        .setTeacher(finder.findTeacherById(2)).setRoom(finder.findRoomByNumber(102))
                        .setTime(new LectureTime(12, 50)));
        university.getTimetable()
                .addLecture(new Lecture().setDate(new LectureDate(2019, 6, 12))
                        .setSubject(finder.findSubjectByName("English")).setGroup(finder.findGroupByName("MB - 1"))
                        .setTeacher(finder.findTeacherById(3)).setRoom(finder.findRoomByNumber(103))
                        .setTime(new LectureTime(14, 50)));
        university.getTimetable()
                .addLecture(new Lecture().setDate(new LectureDate(2019, 7, 10))
                        .setSubject(finder.findSubjectByName("History")).setGroup(finder.findGroupByName("MB - 1"))
                        .setTeacher(finder.findTeacherById(4)).setRoom(finder.findRoomByNumber(104))
                        .setTime(new LectureTime(10, 50)));
        university.getTimetable()
                .addLecture(new Lecture().setDate(new LectureDate(2019, 7, 10))
                        .setSubject(finder.findSubjectByName("Chemistry")).setGroup(finder.findGroupByName("MB - 1"))
                        .setTeacher(finder.findTeacherById(5)).setRoom(finder.findRoomByNumber(105))
                        .setTime(new LectureTime(10, 50)));
    }
}
