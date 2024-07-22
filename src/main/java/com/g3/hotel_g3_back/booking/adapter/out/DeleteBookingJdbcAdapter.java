package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.DeleteBookingRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DeleteBookingJdbcAdapter implements DeleteBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String MARK_AS_DELETED_SQL = "UPDATE Booking SET deleted_at = ? WHERE id = ?";

    public DeleteBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id) {
        try {
            LocalDateTime now = LocalDateTime.now();
            int rowsAffected = jdbcTemplate.update(MARK_AS_DELETED_SQL, now, id);
            if (rowsAffected > 0) {
                System.out.println("Reserva marcada como eliminada con ID: " + id + " a las " + now);
            } else {
                System.out.println("No se encontró reserva con ID: " + id);
            }
        } catch (DataAccessException e) {
            System.out.println("Error al marcar reserva como eliminada: " + e.getMessage());
        }
    }
}

