package ua.com.foxminded.university.repositories;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.university.models.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    @Query(value = "SELECT * FROM lectures WHERE group_id = ?1 AND date = ?2", nativeQuery = true)
    public Set<Lecture> findAllLecturesByGroupIdAndDay(int groupId, LocalDate date);

    @Query(value = "SELECT * FROM lectures WHERE group_id = ?1 AND EXTRACT(MONTH FROM date) = ?2", nativeQuery = true)
    public Set<Lecture> findAllLecturesByGroupIdAndMonth(int groupId, int month);

    @Query(value = "SELECT * FROM lectures WHERE teacher_id = ?1 AND date = ?2", nativeQuery = true)
    public Set<Lecture> findAllLecturesByTeacherIdAndDay(int teacherId, LocalDate date);

    @Query(value = "SELECT * FROM lectures WHERE teacher_id = ?1 AND EXTRACT(MONTH FROM date) = ?2", nativeQuery = true)
    public Set<Lecture> findAllLecturesByTeacherIdAndMonth(int teacherId, int month);
}
