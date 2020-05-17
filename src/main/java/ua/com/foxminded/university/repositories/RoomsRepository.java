package ua.com.foxminded.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.university.models.Room;


public interface RoomsRepository extends JpaRepository<Room, Integer> {
    
}
