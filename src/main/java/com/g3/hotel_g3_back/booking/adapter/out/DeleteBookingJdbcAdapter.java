package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.DeleteBookingRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteBookingJdbcAdapter implements DeleteBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String DELETE_BOOKING_SQL = "DELETE FROM Booking WHERE id = ?";

    public DeleteBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id) {
        try {
            int rowsAffected = jdbcTemplate.update(DELETE_BOOKING_SQL, id);
            if (rowsAffected > 0) {
                System.out.println("Reserva eliminada con ID: " + id);
            } else {
                System.out.println("No se encontró reserva con ID: " + id);
            }
        } catch (DataAccessException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
        }
    }
}

