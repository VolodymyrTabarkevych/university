package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.exceptions.EntityNameExistsException;

@Service
public class RoomService {
    private RoomDao roomDao;

    @Autowired
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public void addRoom(Room room) throws EntityNameExistsException {
        for (Room roomFromDatabase : roomDao.findAll()) {
            if (roomFromDatabase.getNumber() == room.getNumber()) {
                throw new EntityNameExistsException("Room with such number is already exists!");
            }
        }
        roomDao.save(room);
    }

    public void removeRoom(Integer id) {
        roomDao.delete(id);
    }

    public List<Room> viewAllRooms() {
        return roomDao.findAll();
    }

}
