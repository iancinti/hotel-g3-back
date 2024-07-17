package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.CreateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class CreateBookingJdbcAdapter implements CreateBookingRepository {

    @Override
    public void execute(Booking booking) {
        System.out.println("Reserva creada: " + booking);
    }
}