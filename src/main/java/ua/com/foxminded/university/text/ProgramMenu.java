package ua.com.foxminded.university.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import ua.com.foxminded.university.logic.Lecture;
import ua.com.foxminded.university.logic.TestDataForUniversity;
import ua.com.foxminded.university.logic.University;

public class ProgramMenu {
    private final String WRONG_INPUT = "------------------------------" + System.lineSeparator() + "Wrong input!"
            + System.lineSeparator() + "------------------------------";
    University university = new University();
    TextUniversityMenu textMenu = new TextUniversityMenu();

    public void start() throws IOException {
        TestDataForUniversity tdfu = new TestDataForUniversity(university);
        tdfu.createDataForUniversity();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = " ";

        while (!selectedOption.equals("")) {
            textMenu.showOptions();
            try {
                selectedOption = reader.readLine();
                if (selectedOption.equals("a") || selectedOption.equals("b")) {
                    if (selectedOption.equals("a")) {
                        textMenu.showTimetableMenuOptions();
                        selectedOption = reader.readLine();
                        timeTableMenu(selectedOption, reader);
                    } else {
                        textMenu.showUniversityMenuOptions();
                        selectedOption = reader.readLine();
                        universityMenu(selectedOption, reader);
                    }
                } else {
                    System.out.println(WRONG_INPUT);
                }
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT);
            }
        }
    }

    /*-------------------------------------------------------------------------------------------------*/
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
            System.out.println("******************************");
        }
    }

    /*-------------------------------------------------------------------------------------------------*/
    private void universityMenu(String selectedOption, BufferedReader reader) {
        textMenu.showUniversityMenuOptions();
        if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")
                || selectedOption.equals("d") || selectedOption.equals("e")) {
            if (selectedOption.equals("a")) {
                teachersMenu(reader);
            } else if (selectedOption.equals("b")) {
                studentsMenu(reader);
            } else if (selectedOption.equals("c")) {
                groupsMenu(reader);
            } else if (selectedOption.equals("d")) {
                roomsMenu(reader);
            } else if (selectedOption.equals("e")) {
                subjectsMenu(reader);
            } else {
                System.out.println(WRONG_INPUT);
            }
        }
    }

    private void subjectsMenu(BufferedReader reader) {
        textMenu.showSubjectsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b")) {
                if (selectedOption.equals("a")) {
                    String subjectName = reader.readLine();
                    university.addSubject(subjectName);
                } else {
                    String subjectName = reader.readLine();
                    university.removeSubject(subjectName);
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void roomsMenu(BufferedReader reader) {
        textMenu.showRoomsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b")) {
                if (selectedOption.equals("a")) {
                    int roomNumber = Integer.parseInt(reader.readLine());
                    university.addRoom(roomNumber);
                } else {
                    int roomNumber = Integer.parseInt(reader.readLine());
                    university.removeRoom(roomNumber);
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void groupsMenu(BufferedReader reader) {
        textMenu.showGroupsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b")) {
                if (selectedOption.equals("a")) {
                    System.out.println("Enter group name: ");
                    String groupName = reader.readLine();
                    university.addGroup(groupName);
                } else if (selectedOption.equals("b")) {
                    System.out.println("Enter group name: ");
                    String groupName = reader.readLine();
                    university.removeGroup(groupName);
                } else if (selectedOption.equals("c")) {
                    System.out.println("Enter student id: ");
                    int studentId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter group name: ");
                    String groupName = reader.readLine();
                    university.changeStudentGroup(studentId, groupName);
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void studentsMenu(BufferedReader reader) {
        textMenu.showStudentsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b")) {
                if (selectedOption.equals("a")) {
                    do {
                        System.out.println("Enter first name: ");
                        String firstName = reader.readLine();
                        System.out.println("Enter last name: ");
                        String lastName = reader.readLine();
                        System.out.println("Enter student id: ");
                        int studentId = Integer.parseInt(reader.readLine());
                        university.addStudentToUniversity(studentId, firstName, lastName);
                        System.out.println("Do you want to continiue adding(y/enter for exit)?");
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        System.out.println("Enter student id: ");
                        int studentId = Integer.parseInt(reader.readLine());
                        university.removeStudentFromUniversity(studentId);
                        System.out.println("Do you want to continiue removing(y/enter for exit)?");
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                }
            } else {
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void teachersMenu(BufferedReader reader) {
        textMenu.showTeachersMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b")) {
                if (selectedOption.equals("a")) {
                    do {
                        System.out.println("Enter first name: ");
                        String firstName = reader.readLine();
                        System.out.println("Enter last name: ");
                        String lastName = reader.readLine();
                        System.out.println("Enter teacher id: ");
                        int teacherId = Integer.parseInt(reader.readLine());
                        university.addTeacher(teacherId, firstName, lastName);
                        System.out.println("Do you want to continiue adding(y/enter for exit)?");
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        System.out.println("Enter teacher id: ");
                        int teacherId = Integer.parseInt(reader.readLine());
                        university.removeTeacher(teacherId);
                        System.out.println("Do you want to continiue removing(y/enter for exit)?");
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else {
                    System.out.println(WRONG_INPUT);
                }

            } else {
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }

    }

    private void timeTableMenu(String selectedOption, BufferedReader reader) throws IOException {
        int presonId = 0;
        int day = 0;
        int numberOfMonth = 0;
        if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")
                || selectedOption.equals("d")) {
            if (selectedOption.equals("a")) {
                try {
                    System.out.println("Enter student id: ");
                    presonId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter day of this month: ");
                    day = Integer.parseInt(reader.readLine());
                    showFilteredLectures(
                            university.getTimetable().filter().forStudent(presonId).forDay(day).getFilteredLectures());
                } catch (NumberFormatException e) {
                    System.out.println(WRONG_INPUT);
                }
            } else if (selectedOption.equals("b")) {
                try {
                    System.out.println("Enter student id: ");
                    presonId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter month number: ");
                    numberOfMonth = Integer.parseInt(reader.readLine());
                    showFilteredLectures(university.getTimetable().filter().forStudent(presonId).forMonth(numberOfMonth)
                            .getFilteredLectures());
                } catch (NumberFormatException e) {
                    System.out.println(WRONG_INPUT);
                }
            } else if (selectedOption.equals("c")) {
                try {
                    System.out.println("Enter teacher id: ");
                    presonId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter day of this month: ");
                    day = Integer.parseInt(reader.readLine());
                    showFilteredLectures(
                            university.getTimetable().filter().forTeacher(presonId).forDay(day).getFilteredLectures());
                } catch (NumberFormatException e) {
                    System.out.println(WRONG_INPUT);
                }
            } else if (selectedOption.equals("d")) {
                try {
                    System.out.println("Enter teacher id: ");
                    presonId = Integer.parseInt(reader.readLine());
                    System.out.println("Enter month number: ");
                    numberOfMonth = Integer.parseInt(reader.readLine());
                    showFilteredLectures(university.getTimetable().filter().forTeacher(presonId).forMonth(numberOfMonth)
                            .getFilteredLectures());
                } catch (NumberFormatException e) {
                    System.out.println(WRONG_INPUT);
                }
            }
        } else {
            System.out.println(WRONG_INPUT);
        }
    }
}
