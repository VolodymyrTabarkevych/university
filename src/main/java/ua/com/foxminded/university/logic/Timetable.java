package ua.com.foxminded.university.logic;

import java.util.HashSet;
import java.util.Set;

import lombok.Setter;

@Setter
public class Timetable {
    private Set<Lecture> lectures = new HashSet<>();

    public void addLecture(Lecture lecture) {
        if (checkIfLectureToAddHasCorrectDateAndTime(lecture)) {
            lectures.add(lecture);
        } else {
            System.out.println("There is already a lecture on this date!");
        }
    }

    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
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
}
