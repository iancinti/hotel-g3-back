package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RetriveBookingJdbcAdapter implements RetriveBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetriveBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_ALL_BOOKINGS_SQL = "SELECT id, id_customer, id_payment, check_in_date, check_out_date FROM Booking";

    @Override
    public List<Booking> execute() {
        try {
            return jdbcTemplate.query(SELECT_ALL_BOOKINGS_SQL, new BookingRowMapper());
        } catch (DataAccessException e) {
            System.out.println("Error al recuperar reservas: " + e.getMessage());
            return List.of();
        }
    }

    private static class BookingRowMapper implements RowMapper<Booking> {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            booking.setIdCustomer(rs.getInt("id_customer"));
            booking.setIdPayment(rs.getInt("id_payment"));
            booking.setCheckInDate(rs.getDate("check_in_date"));
            booking.setCheckInDate(rs.getDate("check_out_date"));
            return booking;
        }
    }
}
