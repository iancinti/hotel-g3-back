package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class MockBookingAdapter implements RetriveBookingRepository {

    @Override
    public Booking execute() {
        // Devuelve booking de ejemplo
        return new Booking(1, "Ian Cinti", "2024-07-14");
    }
}