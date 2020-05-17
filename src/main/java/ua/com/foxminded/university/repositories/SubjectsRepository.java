package ua.com.foxminded.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.university.models.Subject;

public interface SubjectsRepository extends JpaRepository<Subject, Integer> {

}
