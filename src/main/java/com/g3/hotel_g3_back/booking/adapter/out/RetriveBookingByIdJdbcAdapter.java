package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingByIdRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RetriveBookingByIdJdbcAdapter implements RetriveBookingByIdRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetriveBookingByIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_BOOKING_BY_ID_SQL = "SELECT id, id_customer, id_payment, check_in_date, check_out_date FROM Booking WHERE id = ?";

    @Override
    public Booking execute(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOKING_BY_ID_SQL, new Object[]{id}, new BookingRowMapper());
        } catch (DataAccessException e) {
            System.out.println("Error al recuperar la reserva: " + e.getMessage());
            return null;
        }
    }

    private static class BookingRowMapper implements RowMapper<Booking> {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Booking(
                    rs.getInt("id"),
                    rs.getInt("id_customer"),
                    rs.getInt("id_payment"),
                    rs.getDate("check_in_date"),
                    rs.getDate("check_out_date")
            );
        }
    }
}
