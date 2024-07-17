package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.UpdateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateBookingJdbcAdapter implements UpdateBookingRepository {

    @Override
    public void execute(String id, Booking booking) {
       System.out.println("Reserva actualizada con ID: " + id + " a " + booking);
    }

}