package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.models.Room;
import ua.com.foxminded.university.repositories.RoomsRepository;

@Service
public class RoomService {
    @Autowired
    private RoomsRepository roomsRepository;

    public void addRoom(Room room) throws EntityNameExistsException {
        for (Room roomFromDatabase : roomsRepository.findAll()) {
            if (roomFromDatabase.getNumber() == room.getNumber()) {
                throw new EntityNameExistsException("Room with such number is already exists!");
            }
        }
        roomsRepository.save(room);
    }

    public void removeRoom(Integer id) {
        roomsRepository.deleteById(id);
    }

    public List<Room> viewAllRooms() {
        return roomsRepository.findAll();
    }

}
