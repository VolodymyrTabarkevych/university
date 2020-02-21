package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;

class LectureMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;
    private static final String ENTER_LECTURE_ID = "Enter lecture id: ";
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
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void changeRoom(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter room number: ");
                roomNumber = Integer.parseInt(reader.readLine());
                // finder.findLectureById(lectureId).setRoom(finder.findRoomByNumber(roomNumber));
                System.out.println("Room was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void changeDate(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter year: ");
                year = Integer.parseInt(reader.readLine());
                System.out.println("Enter month: ");
                month = Integer.parseInt(reader.readLine());
                System.out.println("Enter day of month");
                day = Integer.parseInt(reader.readLine());
                // finder.findLectureById(lectureId).setDate(year, month, day);
                System.out.println("Date was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void changeTime(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter start hour: ");
                startHour = Integer.parseInt(reader.readLine());
                System.out.println("Enter start minute: ");
                startMinute = Integer.parseInt(reader.readLine());
                // finder.findLectureById(lectureId).setTime(startHour, startMinute);
                System.out.println("Time was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void changeGroup(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter group name: ");
                groupName = reader.readLine();
                // finder.findLectureById(lectureId).setGroup(finder.findGroupByName(groupName));
                System.out.println("Group was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void changeTeacher(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter teacher id: ");
                personId = Integer.parseInt(reader.readLine());
                // finder.findLectureById(lectureId).setTeacher(finder.findTeacherById(personId));
                System.out.println("Teacher was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void changeSubject(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter subject name: ");
                subjectId = reader.readLine();
                // finder.findLectureById(lectureId).setSubject(finder.findSubjectByName(subjectName));
                System.out.println("Subject was changed!");
                System.out.println(CONTINUE_CHANGING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void removeLecture(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                // university.getTimetable().removeLecture(lectureId);
                System.out.println("Lecture was removed!");
                System.out.println(CONTINUE_REMOVING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addLecture(BufferedReader reader) throws IOException {
        do {
            System.out.println("Enter subject id: ");
            subjectId = Integer.parseInt(reader.readLine());
            System.out.println("Enter teacher id:");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            groupId = Integer.parseInt(reader.readLine());
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
            System.out.println("Enter room id");
            roomId = Integer.parseInt(reader.readLine());
            Lecture lecture = new Lecture().setTeacher(dbCooperator.getTeacherDaoJdbcTemplateImpl().find(personId))
                    .setGroup(dbCooperator.getGroupDaoJdbcTemplateImpl().find(groupId))
                    .setSubject(dbCooperator.getSubjectDaoJdbcTemplateImpl().find(subjectId))
                    .setRoom(dbCooperator.getRoomDaoJdbcTemplateImpl().find(roomId)).setDateTimeBegin(new Timestamp(time));
            dbCooperator.getLectureDaoJdbcTemplateImpl().save(lecture);
            System.out.println("Lecture was added!");
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }
}
