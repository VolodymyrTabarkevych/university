package ua.com.foxminded.university.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import ua.com.foxminded.university.logic.Finder;
import ua.com.foxminded.university.logic.Lecture;
import ua.com.foxminded.university.logic.TestDataForUniversity;
import ua.com.foxminded.university.logic.University;

public class UniversityMenu {
    University university = new University();
    Finder finder;

    public void start() throws IOException {
        TestDataForUniversity tdfu = new TestDataForUniversity(university);
        tdfu.createDataForUniversity();
        university = tdfu.university;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = " ";
        int presonId = 0;
        int day = 0;
        while (!selectedOption.equals("")) {
            showOptions();
            selectedOption = reader.readLine();
            if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")
                    || selectedOption.equals("d")) {
                if (selectedOption.equals("a")) {
                    try {
                        System.out.println("Enter student id: ");
                        presonId = Integer.parseInt(reader.readLine());
                        System.out.println("Enter day of this month: ");
                        day = Integer.parseInt(reader.readLine());
                        finder = new Finder(university);
                        showFilteredLectures(university.getTimetable().filter().forStudent(presonId).forDay(day)
                                .getFilteredLectures(), presonId);
                    } catch (NumberFormatException e) {
                        System.out.println("------------------------------");
                        System.out.println("Wrong input!");
                        System.out.println("------------------------------");
                    }
                } else if (selectedOption.equals("b")) {

                }
            } else {
                System.out.println("------------------------------");
                System.out.println("Wrong input!");
                System.out.println("------------------------------");
            }
        }
    }

    private void showFilteredLectures(Set<Lecture> filteredLectures, int studentId) {
        for (Lecture lecture : filteredLectures) {
            System.out.println("******************************");
            System.out.println("Subject: " + lecture.getSubject().getName());
            System.out.println(
                    "Teacher: " + lecture.getTeacher().getFirstName() + " " + lecture.getTeacher().getLastName());
            System.out.println("Day: " + lecture.getDate());
            System.out.println("Time: " + lecture.getTime());
            System.out.println("Student: " + lecture.getGroup().findStudentById(studentId).getFirstName() + " "
                    + lecture.getGroup().findStudentById(studentId).getLastName());
            System.out.println("******************************");
        }
    }

    private void showOptions() {
        System.out.println("Select option: ");
        System.out.println("a. Show student timetable for day");
        System.out.println("b. Show student timetable for month");
        System.out.println("c. Show teacher timetable for day");
        System.out.println("d. Show teacher timetable for month");
    }
}
