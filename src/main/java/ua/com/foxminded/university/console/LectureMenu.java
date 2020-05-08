package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.foxminded.university.service.LectureService;

@Component
class LectureMenu extends TextUniversityMenu {
    private static final Logger logger = LoggerFactory.getLogger(LectureMenu.class);
    private LectureService lectureService;
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

    @Autowired
    public LectureMenu(LectureService lectureService) {
        this.lectureService = lectureService;
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
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void changeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter room id: ");
            roomId = Integer.parseInt(reader.readLine());
            lectureService.changeRoom(lectureId, roomId);
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
            lectureService.changeDate(lectureId, LocalDate.of(year, month, day));
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
            lectureService.changeTime(lectureId, LocalTime.of(startHour, startMinute),
                    LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20));
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void changeGroup(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            System.out.println("Enter group id: ");
            groupId = Integer.parseInt(reader.readLine());
            lectureService.changeGroup(lectureId, groupId);
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
            lectureService.changeTeacher(lectureId, personId);
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
            lectureService.changeSubject(lectureId, subjectId);
            System.out.println(CONTINUE_CHANGING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeLecture(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter lecture id: ");
            lectureId = Integer.parseInt(reader.readLine());
            lectureService.removeLecture(lectureId);
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
            lectureService.addLecture(personId, groupId, subjectId, roomId, LocalDate.of(year, month, day),
                    LocalTime.of(startHour, startMinute),
                    LocalTime.of(startHour, startMinute).plusHours(1).plusMinutes(20));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }
}
