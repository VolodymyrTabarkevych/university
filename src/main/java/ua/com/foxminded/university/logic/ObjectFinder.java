package ua.com.foxminded.university.logic;

public class ObjectFinder {
    University university;

    public ObjectFinder(University university) {
        this.university = university;
    }

    public Teacher findTeacherById(int id) {
        Teacher result = null;
        for (Teacher teacher : university.getTeachers()) {
            if (teacher.getId() == id) {
                result = teacher;
            }
        }
        return result;
    }

    public Student findStudentById(int id) {
        Student result = null;
        for (Student student : university.getStudents()) {
            if (student.getId() == id) {
                result = student;
            }
        }
        return result;
    }

    public Subject findSubjectByName(String name) {
        Subject result = null;
        for (Subject subject : university.getSubjects()) {
            if (subject.getName().equals(name)) {
                result = subject;
            }
        }
        return result;
    }

    public Room findRoomByNumber(int number) {
        Room result = null;
        for (Room room : university.getRooms()) {
            if (room.getNumber() == number) {
                result = room;
            }
        }
        return result;
    }

    public Group findGroupByName(String name) {
        Group result = null;
        for (Group group : university.getGroups()) {
            if (group.getName().equals(name)) {
                result = group;
            }
        }
        return result;
    }
}
