package ua.com.foxminded.university.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ID")
    private int lectureId;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "START_TIME")
    private LocalTime startTime;
    @Column(name = "END_TIME")
    private LocalTime endTime;

    @Override
    public String toString() {
        return "Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + System.lineSeparator() + "Group: "
                + group.getName() + System.lineSeparator() + "Subject: " + subject.getName() + System.lineSeparator()
                + "Room: " + room.getNumber() + System.lineSeparator() + "Date: " + date.toString()
                + System.lineSeparator() + "Lecture begin: " + startTime.toString() + " Lecture end: "
                + endTime.toString();
    }
}
