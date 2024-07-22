package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.CreateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateBookingJdbcAdapter implements CreateBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_BOOKING_SQL =
            "INSERT INTO Booking (id, id_customer, id_payment, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?)";

    public CreateBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Booking booking) {
        try {
            jdbcTemplate.update(
                    INSERT_BOOKING_SQL,
                    booking.getId(),
                    booking.getIdCustomer(),
                    booking.getIdPayment(),
                    booking.getCheckInDate(),
                    booking.getCheckOutDate()
            );
            System.out.println("Reserva creada: " + booking);
        } catch (DataAccessException e) {
            System.out.println("Error al crear reserva: " + e.getMessage());
        }
    }
}