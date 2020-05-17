package ua.com.foxminded.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.university.models.Teacher;

public interface TeachersRepository extends JpaRepository<Teacher, Integer> {

}
