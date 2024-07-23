package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import com.g3.hotel_g3_back.share.Pagination;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class RetriveRoomsJdbcAdapter implements RetriveRoomsRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetriveRoomsJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pagination<Room> execute(int pageNumber, int pageSize, List<String> types, List<Integer> services) {
        pageNumber = Math.max(1, pageNumber);
        pageSize = Math.max(1, pageSize);

        int offset = (pageNumber - 1) * pageSize;
        StringBuilder countSql = new StringBuilder(
                "SELECT count(*) as cuenta FROM room r " +
                        "LEFT JOIN room_type rt ON r.id_room_type = rt.id_room_type " +
                        "INNER JOIN service_room_type srt ON rt.id_room_type = srt.id_room_type " +
                        "INNER JOIN service s ON srt.id_service = s.id " +
                        "WHERE 1=1"
        );
        StringBuilder sql = new StringBuilder(
                "SELECT r.id_room, r.description, r.number_people, r.price, rt.name as room_type_name " +
                        "FROM room r LEFT JOIN room_type rt ON r.id_room_type = rt.id_room_type " +
                        "INNER JOIN service_room_type srt ON rt.id_room_type = srt.id_room_type " +
                        "INNER JOIN service s ON srt.id_service = s.id " +
                        "WHERE 1=1"
        );

        List<Object> params = new ArrayList<>();

        if (types != null && !types.isEmpty()) {
            sql.append(" AND rt.name IN (");
            countSql.append(" AND rt.name IN (");
            for (int i = 0; i < types.size(); i++) {
                sql.append("?");
                countSql.append("?");
                if (i < types.size() - 1) {
                    sql.append(", ");
                    countSql.append(", ");
                }
                params.add(types.get(i).toUpperCase());
            }
            sql.append(")");
            countSql.append(")");
        }

        if (services != null && !services.isEmpty()) {
            sql.append(" AND s.id IN (");
            countSql.append(" AND s.id IN (");
            for (int i = 0; i < services.size(); i++) {
                sql.append("?");
                countSql.append("?");
                if (i < services.size() - 1) {
                    sql.append(", ");
                    countSql.append(", ");
                }
                params.add(services.get(i));
            }
            sql.append(")");
            countSql.append(")");
        }

        sql.append(" LIMIT ? OFFSET ?");
        params.add(pageSize);
        params.add(offset);
        RowMapper<Integer> countRowMapper = (ResultSet rs, int rowNum) -> rs.getInt("cuenta");
        List<Object> paramsCount = new ArrayList<>(params.subList(0, params.size() - 2));
        Integer totalRecords = jdbcTemplate.queryForObject(countSql.toString(), countRowMapper, paramsCount.toArray());

        return new Pagination<>(
                jdbcTemplate.query(sql.toString(), new RoomRowMapper(), params.toArray()),
                totalRecords != null ? totalRecords : 0
        );
    }

    private static class RoomRowMapper implements RowMapper<Room> {
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