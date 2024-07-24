package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.CreateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.PreparedStatement;
import java.util.Objects;

@Repository
public class CreateBookingJdbcAdapter implements CreateBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public CreateBookingJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_BOOKING_SQL = "INSERT INTO Booking (id_customer, id_payment, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
    private static final String INSERT_BOOKING_SQL2 = "INSERT INTO Booking (id_payment, check_in_date, check_out_date) VALUES (?, ?, ?)";
    private static final String INSERT_PAYMENT_SQL = "INSERT INTO payment_details (state, total_amount) VALUES (?, ?)";

    private static final String STATE_IN_PROGRESS = "INPAGO"; // Usar constantes para estados

    @Override
    public void execute(Booking booking) {
        try {
            Integer paymentId = insertPaymentDetails(booking.getTotalAmount());
            if (paymentId == null) {
                throw new DataAccessException("Fallo al obtener el ID de pago generado") {};
            }

            if (booking.getIdCustomer() == 0){
                jdbcTemplate.update(
                        INSERT_BOOKING_SQL2,
                        paymentId,
                        booking.getCheckInDate(),
                        booking.getCheckOutDate()
                );
            }else {
                jdbcTemplate.update(
                        INSERT_BOOKING_SQL,
                        booking.getIdCustomer(),
                        paymentId,
                        booking.getCheckInDate(),
                        booking.getCheckOutDate()
                );
            }
            System.out.println("Reserva creada: " + booking);
        } catch (DataAccessException e) {
            System.out.println("Error al crear reserva: " + e.getCause().getMessage());
            throw e;
        }
    }

    private Integer insertPaymentDetails(Double totalAmount){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_PAYMENT_SQL, new String[]{"id_payment"}); // Especifique la columna que contiene la clave generada
            ps.setString(1, STATE_IN_PROGRESS);
            ps.setDouble(2,  totalAmount);
            return ps;
        }, keyHolder);
        if (keyHolder.getKeyList().size() == 1) {
            return Objects.requireNonNull(keyHolder.getKey()).intValue();
        } else {
            return null;
        }
    }

}