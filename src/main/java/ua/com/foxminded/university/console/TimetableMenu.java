package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.domain.Student;

public class TimetableMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private Set<Lecture> filteredLectures;
    private LectureMenu lectureMenu;
    private int day = 0;
    private int year = 0;
    private int personId = 0;
    private int month = 0;

    public TimetableMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
        lectureMenu = new LectureMenu(dbCooperator);
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

    private void showTeacherTimetableForMonth(BufferedReader reader) {
        try {
            System.out.println("Enter teacher id: ");
            personId = Integer.parseInt(reader.readLine());
            System.out.println("Enter month number: ");
            month = Integer.parseInt(reader.readLine());
            filteredLectures = new HashSet<Lecture>(dbCooperator.getLectureDao()
                    .findAllLecturesByTeacherIdAndMonth(personId, LocalDate.of(year, month, day)));
            showFilteredLectures(filteredLectures);
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void showFilteredLectures(Set<Lecture> filteredLectures) {
        for (Lecture lecture : filteredLectures) {
            System.out.println(lecture.toString());
            System.out.println("***********************");
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
            Student student = dbCooperator.getStudentDao().find(personId);
            filteredLectures = new HashSet<Lecture>(dbCooperator.getLectureDao()
                    .findAllLecturesByGroupIdAndDay(student.getGroup().getId(), LocalDate.of(year, month, day)));
            showFilteredLectures(filteredLectures);
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
            Student student = dbCooperator.getStudentDao().find(personId);
            filteredLectures = new HashSet<Lecture>(dbCooperator.getLectureDao()
                    .findAllLecturesByGroupIdAndMonth(student.getGroup().getId(), LocalDate.of(year, month, day)));
            showFilteredLectures(filteredLectures);
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
            filteredLectures = new HashSet<Lecture>(dbCooperator.getLectureDao()
                    .findAllLecturesByTeacherIdAndDay(personId, LocalDate.of(year, month, day)));
            showFilteredLectures(filteredLectures);
        } catch (NumberFormatException | IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }
}
