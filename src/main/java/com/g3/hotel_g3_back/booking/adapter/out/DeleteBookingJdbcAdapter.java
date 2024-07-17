package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.DeleteBookingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteBookingJdbcAdapter implements DeleteBookingRepository {

    @Override
    public void execute(String id) {
        System.out.println("Reserva marcada como eliminada con ID: " + id);
    }
}

