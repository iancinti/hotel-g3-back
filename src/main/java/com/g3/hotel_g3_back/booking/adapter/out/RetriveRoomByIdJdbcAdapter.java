package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomByIdRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RetriveRoomByIdJdbcAdapter implements RetriveRoomByIdRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetriveRoomByIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Room execute(Integer idRoom) {
        String sql = "SELECT r.id_room, r.description, r.number_people, r.price, rt.name as room_type_name " +
                "FROM room r LEFT JOIN room_type rt ON r.id_room_type = rt.id_room_type " +
                "WHERE r.id_room = ?";

        return jdbcTemplate.queryForObject(sql, new RoomRowMapper(), idRoom);
    }

    private static class RoomRowMapper implements RowMapper<Room> {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            Room room = new Room();
            room.setIdRoom(rs.getInt("id_room"));
            room.setName(rs.getString("description"));
            room.setNumberPeople(rs.getInt("number_people"));
            room.setPrice(rs.getDouble("price"));
            room.setType(rs.getString("room_type_name"));
            return room;
        }
    }
}




