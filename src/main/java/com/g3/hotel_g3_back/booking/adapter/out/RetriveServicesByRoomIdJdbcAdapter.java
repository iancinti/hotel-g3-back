package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveServicesByRoomIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriveServicesByRoomIdJdbcAdapter implements RetriveServicesByRoomIdRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RetriveServicesByRoomIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Integer> execute(String roomId) {
        String sql = "SELECT s.id " +
                "FROM service s " +
                "JOIN service_room_type srt ON s.id = srt.id_service " +
                "JOIN room_type rt ON srt.id_room_type = rt.id_room_type " +
                "JOIN room r ON rt.id_room_type = r.id_room_type " +
                "WHERE r.id_room = ?";

        int roomIdInt = Integer.parseInt(roomId);
        return jdbcTemplate.queryForList(sql, new Object[]{roomIdInt}, Integer.class);
    }
}