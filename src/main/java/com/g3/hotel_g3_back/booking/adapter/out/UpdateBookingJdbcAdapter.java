package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.UpdateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpdateBookingJdbcAdapter implements UpdateBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String UPDATE_BOOKING_SQL = "UPDATE Booking SET id_customer = ?, id_payment = ?, check_in_date = ?, check_out_date = ? WHERE id = ?";

    public UpdateBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id, Booking booking) {
        try {
            jdbcTemplate.update(
                    UPDATE_BOOKING_SQL,
                    booking.getIdCustomer(),
                    booking.getIdPayment(),
                    booking.getCheckInDate(),
                    booking.getCheckOutDate(),
                    id
            );
            System.out.println("Reserva actualizada con ID: " + id + " a " + booking);
        } catch (DataAccessException e) {
            System.out.println("Error al actualizar reserva: " + e.getMessage());
        }
    }
}