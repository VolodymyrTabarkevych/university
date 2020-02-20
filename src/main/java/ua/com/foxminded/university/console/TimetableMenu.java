package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.LectureDate;
import ua.com.foxminded.university.domain.Timetable;

public class TimetableMenu extends TextUniversityMenu {
    Timetable timetable;
    // private LectureMenu lectureMenu = new LectureMenu();
    private int day = 0;
    private int year = 0;
    private int personId = 0;
    private int month = 0;

    public TimetableMenu(DbCooperator dbCooperator) {
        Set<Lecture> lectures = new HashSet<>();
        for (Lecture lecture : dbCooperator.getLectureDaoJdbcTemplateImpl().findAll()) {
            lectures.add(lecture);
        }
        timetable = new Timetable(lectures);
    }

    void start(String selectedOption, BufferedReader reader) {
        switch (selectedOption) {
        case "a":
            showStudentTimeTableForDay(reader);
            break;
        case "b":
            showStudentTimetableForMonth(reader);
            break;
        case "c":
            showTeacherTimetableForDay(reader);
            break;
        case "d":
            showTeacherTimetableForMonth(reader);
            break;
        case "e":
            // lectureMenu.start(reader);
            break;
        default:
            System.out.println(WRONG_INPUT);
        }
    }

    private void showTeacherTimetableForMonth(BufferedReader reader) {
        try {
            System.out.println("Enter teacher id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter month number: ");
            month = Integer.parseInt(reader.readLine());
            showFilteredLectures(
                    university.getTimetable().filter().forTeacher(personId).forMonth(month).getFilteredLectures());
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void showFilteredLectures(Set<Lecture> filteredLectures) {
        for (Lecture lecture : filteredLectures) {
            System.out.println("******************************");
            System.out.println("Subject: " + lecture.getSubject().getName());
            System.out.println(
                    "Teacher: " + lecture.getTeacher().getFirstName() + " " + lecture.getTeacher().getLastName());
            System.out.println("Month: " + lecture.getDate().getMonth());
            System.out.println("Day: " + lecture.getDate().getDay());
            System.out.println("Time: " + lecture.getTime().getStartHour() + "h " + lecture.getTime().getStartMinute()
                    + "m | " + lecture.getTime().getEndHour() + "h " + lecture.getTime().getEndMinute() + "m");
            System.out.println("Group: " + lecture.getGroup().getName());
            System.out.println("******************************");
        }
    }

    private void showStudentTimeTableForDay(BufferedReader reader) {
        try {
            System.out.println("Enter student id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year:");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month:");
            month = Integer.parseInt(reader.readLine());
            System.out.println("Enter day: ");
            day = Integer.parseInt(reader.readLine());
            showFilteredLectures(university.getTimetable().filter().forStudent(personId)
                    .forDay(new LectureDate(year, month, day)).getFilteredLectures());
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void showStudentTimetableForMonth(BufferedReader reader) {
        try {
            System.out.println("Enter student id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter month number: ");
            month = Integer.parseInt(reader.readLine());
            showFilteredLectures(
                    university.getTimetable().filter().forStudent(personId).forMonth(month).getFilteredLectures());
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void showTeacherTimetableForDay(BufferedReader reader) {
        try {
            System.out.println("Enter teacher id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year:");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month:");
            month = Integer.parseInt(reader.readLine());
            System.out.println("Enter day: ");
            day = Integer.parseInt(reader.readLine());
            showFilteredLectures(university.getTimetable().filter().forTeacher(personId)
                    .forDay(new LectureDate(year, month, day)).getFilteredLectures());
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }
}
