package ua.com.foxminded.university.service;

import java.util.List;

import javax.sql.DataSource;

import ua.com.foxminded.university.dao.RoomDao;
import ua.com.foxminded.university.domain.Room;

public class RoomService {
    private RoomDao roomDao;

    public RoomService(DataSource dataSource) {
        this.roomDao = new RoomDao(dataSource);
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
