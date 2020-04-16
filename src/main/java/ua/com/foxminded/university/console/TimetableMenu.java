package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import javax.sql.DataSource;

import ua.com.foxminded.universit.service.TimetableService;
import ua.com.foxminded.university.domain.Lecture;

public class TimetableMenu extends TextUniversityMenu {
    private TimetableService timetableService;
    private LectureMenu lectureMenu;
    private int day = 0;
    private int year = 0;
    private int personId = 0;
    private int month = 0;

    public TimetableMenu(DataSource dataSource) {
        this.timetableService = new TimetableService(dataSource);
        lectureMenu = new LectureMenu(dataSource);
    }

    public void start(String selectedOption, BufferedReader reader) {
        switch (selectedOption) {
            case "p":
                break;
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
                lectureMenu.start(reader);
                break;
            default:
                System.out.println(WRONG_INPUT);
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
            showFilteredLectures(timetableService.getStudentTimeTableForDay(personId, LocalDate.of(year, month, day)));
        } catch (NumberFormatException | IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void showStudentTimetableForMonth(BufferedReader reader) {
        try {
            System.out.println("Enter student id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year:");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month number: ");
            month = Integer.parseInt(reader.readLine());
            showFilteredLectures(
                    timetableService.getStudentTimetableForMonth(personId, LocalDate.of(year, month, day)));
        } catch (NumberFormatException | IOException e) {
            System.err.println(WRONG_INPUT);
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
            showFilteredLectures(timetableService.getTeacherTimetableForDay(personId, LocalDate.of(year, month, day)));
        } catch (NumberFormatException | IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void showTeacherTimetableForMonth(BufferedReader reader) {
        try {
            System.out.println("Enter teacher id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter year:");
            year = Integer.parseInt(reader.readLine());
            System.out.println("Enter month number: ");
            month = Integer.parseInt(reader.readLine());
            showFilteredLectures(
                    timetableService.getTeacherTimetableForMonth(personId, LocalDate.of(year, month, day)));
        } catch (NumberFormatException | IOException e) {
            System.err.println(WRONG_INPUT);
        }
    }

    private void showFilteredLectures(Set<Lecture> filteredLectures) {
        for (Lecture lecture : filteredLectures) {
            System.out.println(lecture.toString());
            System.out.println("***********************");
        }
    }
}
