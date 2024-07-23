package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import com.g3.hotel_g3_back.share.Pagination;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RetriveRoomsJdbcAdapter implements RetriveRoomsRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetriveRoomsJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pagination<Room> execute(int pageNumber, int pageSize, List<String> types, List<Integer> serviceIds) {
        pageNumber = Math.max(1, pageNumber);
        pageSize = Math.max(1, pageSize);

        int offset = (pageNumber - 1) * pageSize;

        StringBuilder sql = new StringBuilder(
                "SELECT r.id_room, r.description, r.number_people, r.price, rt.name as room_type_name, rt.id_room_type " +
                        "FROM room r " +
                        "LEFT JOIN room_type rt ON r.id_room_type = rt.id_room_type " +
                        "LEFT JOIN service_room_type srt ON rt.id_room_type = srt.id_room_type " +
                        "WHERE 1=1"
        );

        List<Object> params = new ArrayList<>();

        if (types != null && !types.isEmpty()) {
            sql.append(" AND rt.name IN (");
            for (int i = 0; i < types.size(); i++) {
                sql.append("?");
                if (i < types.size() - 1) {
                    sql.append(", ");
                }
                params.add(types.get(i).toUpperCase());
            }
            sql.append(")");
        }

        if (serviceIds != null && !serviceIds.isEmpty()) {
            sql.append(" AND srt.id_service IN (");
            for (int i = 0; i < serviceIds.size(); i++) {
                sql.append("?");
                if (i < serviceIds.size() - 1) {
                    sql.append(", ");
                }
                params.add(serviceIds.get(i));
            }
            sql.append(")");
        }

        sql.append(" GROUP BY r.id_room, rt.name, r.description, r.number_people, r.price, rt.id_room_type");
        sql.append(" LIMIT ? OFFSET ?");
        params.add(pageSize);
        params.add(offset);

        String serviceSql = "SELECT rt.id_room_type, array_agg(s.id) as services " +
                "FROM service_room_type srt " +
                "JOIN room_type rt ON srt.id_room_type = rt.id_room_type " +
                "JOIN service s ON srt.id_service = s.id " +
                "GROUP BY rt.id_room_type";

        RowMapper<Room> roomRowMapper = (ResultSet rs, int rowNum) -> {
            Room room = new Room();
            room.setIdRoom(rs.getInt("id_room"));
            room.setName(rs.getString("description"));
            room.setNumberPeople(rs.getInt("number_people"));
            room.setPrice(rs.getDouble("price"));
            room.setType(rs.getString("room_type_name"));
            room.setServices(new ArrayList<>());
            return room;
        };

        List<Room> rooms = jdbcTemplate.query(sql.toString(), roomRowMapper, params.toArray());

        RowMapper<RoomService> roomServiceRowMapper = (ResultSet rs, int rowNum) -> {
            Integer roomTypeId = rs.getInt("id_room_type");
            Array servicesArray = rs.getArray("services");
            List<Integer> services = servicesArray != null ? Arrays.asList((Integer[]) servicesArray.getArray()) : new ArrayList<>();
            return new RoomService(roomTypeId, services);
        };

        List<RoomService> roomServices = jdbcTemplate.query(serviceSql, roomServiceRowMapper);

        Map<Integer, List<Integer>> roomServicesMap = roomServices.stream()
                .collect(Collectors.toMap(RoomService::getRoomTypeId, RoomService::getServices));

        rooms.forEach(room -> room.setServices(roomServicesMap.getOrDefault(room.getIdRoom(), new ArrayList<>())));

        Integer totalRecords = jdbcTemplate.queryForObject(
                "SELECT COUNT(DISTINCT r.id_room) FROM room r " +
                        "LEFT JOIN room_type rt ON r.id_room_type = rt.id_room_type " +
                        "LEFT JOIN service_room_type srt ON rt.id_room_type = srt.id_room_type " +
                        "WHERE 1=1", Integer.class
        );

        return new Pagination<>(rooms, totalRecords != null ? totalRecords : 0);
    }

    private static class RoomService {
        private Integer roomTypeId;
        private List<Integer> services;

        public RoomService(Integer roomTypeId, List<Integer> services) {
            this.roomTypeId = roomTypeId;
            this.services = services;
        }

        public Integer getRoomTypeId() {
            return roomTypeId;
        }

        public List<Integer> getServices() {
            return services;
        }
    }
}