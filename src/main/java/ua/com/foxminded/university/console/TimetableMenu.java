package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.foxminded.university.domain.Lecture;
import ua.com.foxminded.university.service.TimetableService;

@Component
public class TimetableMenu extends TextUniversityMenu {
    private static final Logger logger = LoggerFactory.getLogger(TimetableMenu.class);
    private TimetableService timetableService;
    private LectureMenu lectureMenu;
    private int day = 1;
    private int year = 1995;
    private int personId = 0;
    private int month = 1;

    @Autowired
    public TimetableMenu(TimetableService timetableService, LectureMenu lectureMenu) {
        this.timetableService = timetableService;
        this.lectureMenu = lectureMenu;
    }

    public void start(String selectedOption, BufferedReader reader) {
        try {
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
        } catch (IOException | NumberFormatException e) {
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void showStudentTimeTableForDay(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter student id: ");
        personId = Integer.parseInt(reader.readLine());
        System.out.println("Enter year:");
        year = Integer.parseInt(reader.readLine());
        System.out.println("Enter month:");
        month = Integer.parseInt(reader.readLine());
        System.out.println("Enter day: ");
        day = Integer.parseInt(reader.readLine());
        showFilteredLectures(timetableService.getStudentTimeTableForDay(personId, LocalDate.of(year, month, day)));
    }

    private void showStudentTimetableForMonth(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter student id: ");
        personId = Integer.parseInt(reader.readLine());
        System.out.println("Enter year:");
        year = Integer.parseInt(reader.readLine());
        System.out.println("Enter month number: ");
        month = Integer.parseInt(reader.readLine());
        showFilteredLectures(timetableService.getStudentTimetableForMonth(personId, LocalDate.of(year, month, day)));
    }

    private void showTeacherTimetableForDay(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter teacher id: ");
        personId = Integer.parseInt(reader.readLine());
        System.out.println("Enter year:");
        year = Integer.parseInt(reader.readLine());
        System.out.println("Enter month:");
        month = Integer.parseInt(reader.readLine());
        System.out.println("Enter day: ");
        day = Integer.parseInt(reader.readLine());
        showFilteredLectures(timetableService.getTeacherTimetableForDay(personId, LocalDate.of(year, month, day)));
    }

    private void showTeacherTimetableForMonth(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter teacher id: ");
        personId = Integer.parseInt(reader.readLine());
        System.out.println("Enter year:");
        year = Integer.parseInt(reader.readLine());
        System.out.println("Enter month number: ");
        month = Integer.parseInt(reader.readLine());
        showFilteredLectures(timetableService.getTeacherTimetableForMonth(personId, LocalDate.of(year, month, day)));
    }

    private void showFilteredLectures(Set<Lecture> filteredLectures) {
        for (Lecture lecture : filteredLectures) {
            System.out.println(lecture.toString());
            System.out.println("***********************");
        }
    }
}
