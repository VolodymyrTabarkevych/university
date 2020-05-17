package ua.com.foxminded.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.university.models.Student;

public interface StudentsRepository extends JpaRepository<Student, Integer> {

}
