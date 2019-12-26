package ua.com.foxminded.university.domain;

public class ObjectFinder {
    University university;

    public ObjectFinder(University university) {
        this.university = university;
    }

    public Teacher findTeacherById(int id) {
        Teacher result = new Teacher(0, "", "");
        for (Teacher teacher : university.getTeachers()) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        System.out.println("No teacher with such id! You can set teacher later in lecture menu.");
        return result;
    }

    public Student findStudentById(int id) {
        Student result = null;
        for (Student student : university.getStudents()) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("No student with such id! You can set student later in lecture menu.");
        return result;
    }

    public Subject findSubjectByName(String name) {
        Subject result = null;
        for (Subject subject : university.getSubjects()) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }
        System.out.println("No subject with such name! You can set subject later in lecture menu.");
        return result;
    }

    public Room findRoomByNumber(int number) {
        Room result = null;
        for (Room room : university.getRooms()) {
            if (room.getNumber() == number) {
                return room;
            }
        }
        System.out.println("No room with such number! You can set room later in lecture menu.");
        return result;
    }

    public Group findGroupByName(String name) {
        Group result = null;
        for (Group group : university.getGroups()) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        System.out.println("No group with such name! You can set group later in lecture menu.");
        return result;
    }

    public Lecture findLectureById(int id) {
        Lecture result = null;
        for (Lecture lecture : university.getTimetable().getLectures()) {
            if (lecture.getLectureId() == id) {
                return lecture;
            }
        }
        System.out.println("No lecture with such id!");
        return result;
    }
}
