package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingByIdRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class RetriveBookingByIdJdbcAdapter implements RetriveBookingByIdRepository {

    @Override
    public Booking execute(String id) {
        return new Booking("1", "Cinti Ian", "14-07-2024");
    }
}
