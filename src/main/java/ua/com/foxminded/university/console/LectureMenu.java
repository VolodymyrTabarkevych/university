package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;

class LectureMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
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
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void changeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter room number: ");
            roomId = Integer.parseInt(reader.readLine());
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setRoom(dbCooperator.getRoomDaoJdbcTemplateImpl().find(roomId));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
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
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setDate(LocalDate.of(year, month, day));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
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
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setStartTime(LocalTime.of(startHour, startMinute));
            lecture.setEndTime(LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
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
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setGroup(dbCooperator.getGroupDaoJdbcTemplateImpl().find(personId));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
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
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setTeacher(dbCooperator.getTeacherDaoJdbcTemplateImpl().find(personId));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
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
            Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(lectureId);
            lecture.setSubject(dbCooperator.getSubjectDaoJdbcTemplateImpl().find(subjectId));
            dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeLecture(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            dbCooperator.getLectureDaoJdbcTemplateImpl().delete(lectureId);
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
            Lecture lecture = new Lecture.Builder()
                    .setTeacher(dbCooperator.getTeacherDaoJdbcTemplateImpl().find(personId))
                    .setGroup(dbCooperator.getGroupDaoJdbcTemplateImpl().find(groupId))
                    .setSubject(dbCooperator.getSubjectDaoJdbcTemplateImpl().find(subjectId))
                    .setRoom(dbCooperator.getRoomDaoJdbcTemplateImpl().find(roomId))
                    .setDate(LocalDate.of(year, month, day)).setStartTime(LocalTime.of(startHour, startMinute))
                    .setEndTime(LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20)).build();
            dbCooperator.getLectureDaoJdbcTemplateImpl().save(lecture);
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }
}
