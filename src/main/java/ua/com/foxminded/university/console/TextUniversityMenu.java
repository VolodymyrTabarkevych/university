package ua.com.foxminded.university.console;

public class TextUniversityMenu {
    private static final String BACK_BUTTON = "p. Go to the main menu";
    private static final String DIVIDING_LINE = "------------------------------";

    public void showOptions() {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Select option(enter for exit): ");
        System.out.println("a. Timetable menu");
        System.out.println("b. University menu");
        System.out.println("++++++++++++++++++++++++++++++");
    }

    public void showUniversityMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("What you want to do: ");
        System.out.println("a. Work with teachers");
        System.out.println("b. Work with students");
        System.out.println("c. Work with groups");
        System.out.println("d. Work with rooms");
        System.out.println("e. Work with subjects");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showTeachersMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add teacher");
        System.out.println("b. Remove teacher");
        System.out.println("c. View all teachers");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showStudentsMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add student");
        System.out.println("b. Remove student");
        System.out.println("c. Change student group");
        System.out.println("d. View all students");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showGroupsMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add group");
        System.out.println("b. Remove group");
        System.out.println("c. Add student to group");
        System.out.println("d. View all Groups");
        System.out.println("e. View all students in group");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showSubjectsMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add subject");
        System.out.println("b. Remove subject");
        System.out.println("c. View all subjects");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showRoomsMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add room");
        System.out.println("b. Remove room");
        System.out.println("c. View all rooms");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showTimetableMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Show student timetable for day");
        System.out.println("b. Show student timetable for month");
        System.out.println("c. Show teacher timetable for day");
        System.out.println("d. Show teacher timetable for month");
        System.out.println("e. Work with lectures");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }

    public void showLecturesMenuOptions() {
        System.out.println(DIVIDING_LINE);
        System.out.println("a. Add lecture");
        System.out.println("b. Remove lecture");
        System.out.println("c. Change subject");
        System.out.println("d. Change teacher");
        System.out.println("e. Change group");
        System.out.println("f. Change date");
        System.out.println("g. Change time");
        System.out.println("h. Change room");
        System.out.println(BACK_BUTTON);
        System.out.println(DIVIDING_LINE);
    }
}
