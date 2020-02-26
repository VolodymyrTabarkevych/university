package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Room;

public class RoomDao implements CrudDao<Room> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM rooms";
    private final String SQL_FIND_BY_ID = "SELECT * FROM rooms WHERE id = ?";
    private final String SQL_SAVE_ROOM = "INSERT INTO rooms (number) VALUES (?)";
    private final String SQL_UPDATE_ROOM = "UPDATE rooms SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_ROOM = "DELETE FROM rooms WHERE id = ?";

    public RoomDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Room> roomRowMapper = (ResultSet resultSet, int i) -> {
        Room room = new Room(resultSet.getInt("id"), resultSet.getInt("number"));
        return room;
    };

    @Override
    public Room find(Integer id) {
        Room room = template.query(SQL_FIND_BY_ID, roomRowMapper, id).get(0);
        if (room == null) {
            System.out.println("No room with such id!");
        }
        return room;
    }

    @Override
    public void save(Room room) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_SAVE_ROOM, room.getNumber());
        if (rowsAffected > 0) {
            System.out.println("Room has been added!");
        } else {
            System.out.println("Room hasn't been added!");
        }
    }

    @Override
    public void update(Room room) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_UPDATE_ROOM, room.getNumber(), room.getId());
        if (rowsAffected > 0) {
            System.out.println("Info has been updated!");
        } else {
            System.out.println("Info hasn't been updated!");
        }
    }

    @Override
    public void delete(Integer id) {
        int rowsAffected = 0;
        rowsAffected = template.update(SQL_DELETE_ROOM, id);
        if (rowsAffected > 0) {
            System.out.println("Room has been removed!");
        } else {
            System.out.println("Room hasn't been removed!");
        }

    }

    @Override
    public List<Room> findAll() {
        return template.query(SQL_FIND_ALL, roomRowMapper);
    }

}
