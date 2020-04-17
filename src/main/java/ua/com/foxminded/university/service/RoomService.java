package ua.com.foxminded.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.domain.Room;

@Service
public class RoomService {
    private RoomDao roomDao;

    @Autowired
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public int addRoom(Room room) {
        return roomDao.save(room);
    }

    public int removeRoom(Integer id) {
        return roomDao.delete(id);
    }

    public List<Room> viewAllRooms() {
        return roomDao.findAll();
    }

}
