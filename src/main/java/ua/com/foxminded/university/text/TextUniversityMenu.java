package ua.com.foxminded.university.text;

public class TextUniversityMenu {
    public void showOptions() {
        System.out.println("Select option: ");
        System.out.println("a. Timetable menu");
        System.out.println("b. University menu");
    }

    public void showUniversityMenuOptions() {
        System.out.println("What you want to do: ");
        System.out.println("a. Work with teachers");
        System.out.println("b. Work with students");
        System.out.println("c. Work with groups");
        System.out.println("d. Work with rooms");
        System.out.println("e. Work with subjects");
    }

    public void showTeachersMenuOptions() {
        System.out.println("a. Add teacher");
        System.out.println("b. Remove teacher");
    }

    public void showStudentsMenuOptions() {
        System.out.println("a. Add student");
        System.out.println("b. Remove student");
        System.out.println("c. Change student group");
    }

    public void showGroupsMenuOptions() {
        System.out.println("a. Add group");
        System.out.println("b. Remove group");
        System.out.println("c. Add student to group");
    }

    public void showSubjectsMenuOptions() {
        System.out.println("a. Add subject");
        System.out.println("b. Remove subject");
    }

    public void showRoomsMenuOptions() {
        System.out.println("a. Add room");
        System.out.println("b. Remove room");
    }

    public void showTimetableMenuOptions() {
        System.out.println("a. Show student timetable for day");
        System.out.println("b. Show student timetable for month");
        System.out.println("c. Show teacher timetable for day");
        System.out.println("d. Show teacher timetable for month");
        System.out.println("e. Work with lectures");
    }

    public void showLecturesMenuOptions() {
        System.out.println("a. Add lecture");
        System.out.println("b. Remove lecture");
        System.out.println("c. Change subject");
        System.out.println("d. Change teacher");
        System.out.println("e. Change group");
        System.out.println("f. Change date");
        System.out.println("g. Change time");
        System.out.println("h. Change room");
    }
}
