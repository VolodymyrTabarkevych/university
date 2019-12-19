package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Timetable {
    private Set<Lecture> lectures = new HashSet<>();

    public void addLecture(Lecture lecture) {
        if (checkIfLectureToAddHasCorrectDateAndTime(lecture)) {
            lectures.add(lecture);
        } else {
            System.out.println("There is already a lecture on this date!");
        }
    }

    public void removeLecture(int lectureId) {
        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == lectureId) {
                lectures.remove(lecture);
                return;
            }
        }
        System.out.println("No lecture with such id!");
    }

    public LectureFilter filter() {
        return new LectureFilter(lectures);
    }

    private boolean checkIfLectureToAddHasCorrectDateAndTime(Lecture lecture) {
        Boolean result = true;
        for (Lecture lectureFromList : lectures) {
            if (lectureFromList.getDate().getMonth() == lecture.getDate().getMonth()) {
                if (lectureFromList.getDate().getDay() == lecture.getDate().getDay()) {
                    if (lectureFromList.getTime().getStartHour() <= lecture.getTime().getStartHour()
                            && lectureFromList.getTime().getEndHour() >= lecture.getTime().getStartHour()
                            || lectureFromList.getTime().getStartHour() <= lecture.getTime().getEndHour()
                                    && lectureFromList.getTime().getEndHour() >= lecture.getTime().getEndHour()) {
                        return false;
                    }
                }
            }
        }
        return result;
    }

    public void viewAllLectures() {
        for (Lecture lecture : lectures) {
            System.out.println(lecture.getLectureId());
        }
    }
}
