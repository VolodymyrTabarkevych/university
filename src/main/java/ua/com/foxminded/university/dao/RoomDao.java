package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.university.domain.Room;

@Repository
public class RoomDao implements CrudDao<Room> {
    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM rooms";
    private final String SQL_FIND_BY_ID = "SELECT * FROM rooms WHERE id = ?";
    private final String SQL_SAVE_ROOM = "INSERT INTO rooms (number) VALUES (?)";
    private final String SQL_UPDATE_ROOM = "UPDATE rooms SET number = ?, WHERE id = ?";
    private final String SQL_DELETE_ROOM = "DELETE FROM rooms WHERE id = ?";

    @Autowired
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
        return room;
    }

    @Override
    public void save(Room room) {
        template.update(SQL_SAVE_ROOM, room.getNumber());
    }

    @Override
    public void update(Room room) {
        template.update(SQL_UPDATE_ROOM, room.getNumber(), room.getId());
    }

    @Override
    public void delete(Integer id) {
        template.update(SQL_DELETE_ROOM, id);
    }

    @Override
    public List<Room> findAll() {
        return template.query(SQL_FIND_ALL, roomRowMapper);
    }

}
