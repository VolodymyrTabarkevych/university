package ua.com.foxminded.university.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.university.domain.Room;

public class RoomDaoJdbcTemplateImpl implements RoomDao {
    private JdbcTemplate template;
    private final String SQL_SELECT_ALL = "SELECT * FROM rooms";

    public RoomDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Room> roomRowMapper = (ResultSet resultSet, int i) -> {
        return new Room(resultSet.getInt("number"));
    };

    @Override
    public Room find(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Room model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Room model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Room> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
