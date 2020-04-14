package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import ua.com.foxminded.university.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;

class LectureMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private int rowsAffected = 0;
    private int lectureId = 0;
    private int subjectId = 0;
    private int groupId = 0;
    private int year = 0;
    private int startHour = 0;
    private int startMinute = 0;
    private int roomId = 0;
    private int day = 0;
    private int personId = 0;
    private int month = 0;
    private String selectedOption = "";

    public LectureMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    void start(BufferedReader reader) {
        showLecturesMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
                case "p":
                    break;
                case "a":
                    addLecture(reader);
                    break;
                case "b":
                    removeLecture(reader);
                    break;
                case "c":
                    changeSubject(reader);
                    break;
                case "d":
                    changeTeacher(reader);
                    break;
                case "e":
                    changeGroup(reader);
                    break;
                case "f":
                    changeDate(reader);
                    break;
                case "g":
                    changeTime(reader);
                    break;
                case "h":
                    changeRoom(reader);
                    break;
                default:
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void changeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter room number: ");
            roomId = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setRoom(dbCooperator.getRoomDao().find(roomId));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeDate(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year: ");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month: ");
            month = Integer.parseInt(reader.readLine());
            System.out.println("Enter day of month");
            day = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setDate(LocalDate.of(year, month, day));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));

    }

    private void changeTime(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter start hour: ");
            startHour = Integer.parseInt(reader.readLine());
            System.out.println("Enter start minute: ");
            startMinute = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setStartTime(LocalTime.of(startHour, startMinute));
            lecture.setEndTime(LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeGroup(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group name: ");
            groupId = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setGroup(dbCooperator.getGroupDao().find(groupId));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeTeacher(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter teacher id: ");
            personId = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setTeacher(dbCooperator.getTeacherDao().find(personId));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeSubject(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter subject name: ");
            subjectId = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDao().find(lectureId);
            lecture.setSubject(dbCooperator.getSubjectDao().find(subjectId));
            rowsAffected = dbCooperator.getLectureDao().update(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_UPDATED);
            } else {
                System.err.println(DATA_HASNT_BEEN_UPDATED);
            }
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeLecture(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            rowsAffected = dbCooperator.getLectureDao().delete(lectureId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.err.println(DATA_HASNT_BEEN_DELETED);
            }
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void addLecture(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter subject id: ");
            subjectId = Integer.parseInt(reader.readLine());
            System.out.println("Enter teacher id:");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            groupId = Integer.parseInt(reader.readLine());
            System.out.println("Enter room id");
            roomId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year:");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month: ");
            month = Integer.parseInt(reader.readLine());
            System.out.println("Enter day: ");
            day = Integer.parseInt(reader.readLine());
            System.out.println("Enter start hour: ");
            startHour = Integer.parseInt(reader.readLine());
            System.out.println("Enter start minute");
            startMinute = Integer.parseInt(reader.readLine());
            Lecture lecture = new Lecture.Builder().setTeacher(dbCooperator.getTeacherDao().find(personId))
                    .setGroup(dbCooperator.getGroupDao().find(groupId))
                    .setSubject(dbCooperator.getSubjectDao().find(subjectId))
                    .setRoom(dbCooperator.getRoomDao().find(roomId)).setDate(LocalDate.of(year, month, day))
                    .setStartTime(LocalTime.of(startHour, startMinute))
                    .setEndTime(LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20)).build();
            rowsAffected = dbCooperator.getLectureDao().save(lecture);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_ADDED);
            } else {
                System.err.println(DATA_HASNT_BEEN_ADDED);
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }
}
