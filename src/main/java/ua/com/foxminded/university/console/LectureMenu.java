package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.domain.Lecture;

/*class LectureMenu extends Menu {
    private static final String ENTER_LECTURE_ID = "Enter lecture id: ";
    private int lectureId = 0;
    private String subjectName = "";
    private String groupName = "";
    private int year = 0;
    private int startHour = 0;
    private int startMinute = 0;
    private int roomNumber = 0;
    private int day = 0;
    private int personId = 0;
    private int month = 0;
    private String selectedOption = "";

    void start(BufferedReader reader) {
        textMenu.showLecturesMenuOptions();
        try {
            selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c") || selectedOption.equals("d")
                    || selectedOption.equals("e") || selectedOption.equals("f") || selectedOption.equals("g")
                    || selectedOption.equals("h")) {
                if (selectedOption.equals("a")) {
                    addLecture(reader);
                } else if (selectedOption.equals("b")) {
                    removeLecture(reader);
                } else if (selectedOption.equals("c")) {
                    changeSubject(reader);
                } else if (selectedOption.equals("d")) {
                    changeTeacher(reader);
                } else if (selectedOption.equals("e")) {
                    changeGroup(reader);
                } else if (selectedOption.equals("f")) {
                    changeDate(reader);
                } else if (selectedOption.equals("g")) {
                    changeTime(reader);
                } else if (selectedOption.equals("h")) {
                    changeRoom(reader);
                }
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
                //finder.findLectureById(lectureId).setRoom(finder.findRoomByNumber(roomNumber));
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
                //finder.findLectureById(lectureId).setDate(year, month, day);
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
                //finder.findLectureById(lectureId).setTime(startHour, startMinute);
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
                //finder.findLectureById(lectureId).setGroup(finder.findGroupByName(groupName));
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
                //finder.findLectureById(lectureId).setTeacher(finder.findTeacherById(personId));
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
                subjectName = reader.readLine();
                //finder.findLectureById(lectureId).setSubject(finder.findSubjectByName(subjectName));
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
                //university.getTimetable().removeLecture(lectureId);
                System.out.println("Lecture was removed!");
                System.out.println(CONTINUE_REMOVING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addLecture(BufferedReader reader) {
        try {
            do {
                System.out.println(ENTER_LECTURE_ID);
                lectureId = Integer.parseInt(reader.readLine());
                System.out.println("Enter subject name: ");
                subjectName = reader.readLine();
                System.out.println("Enter teacher id:");
                personId = Integer.parseInt(reader.readLine());
                System.out.println("Enter group name: ");
                groupName = reader.readLine();
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
                System.out.println("Enter room number");
                roomNumber = Integer.parseInt(reader.readLine());
                /*university.getTimetable().addLecture(new Lecture().setSubject(finder.findSubjectByName(subjectName))
                        .setTeacher(finder.findTeacherById(personId)).setGroup(finder.findGroupByName(groupName))
                        .setDate(year, month, day).setTime(startHour, startMinute)
                        .setRoom(finder.findRoomByNumber(roomNumber)).setLectureId(lectureId).build());
                System.out.println("Lecture was added!");
                System.out.println(CONTINUE_ADDING);
                selectedOption = reader.readLine();
            } while (!selectedOption.equals(""));
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }
}*/
