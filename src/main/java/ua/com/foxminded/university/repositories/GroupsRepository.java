package ua.com.foxminded.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.university.models.Group;

public interface GroupsRepository extends JpaRepository<Group, Integer> {

}
