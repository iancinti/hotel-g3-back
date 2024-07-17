package com.g3.hotel_g3_back.booking.adapter.out;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RetriveBookingJdbcAdapter implements RetriveBookingRepository {

    @Override
    public List<Booking> execute() {
        return Arrays.asList(
                new Booking("", "Ian Cinti", "2024-07-14"),
                new Booking("", "Juan Perez", "2024-07-15")
        );
    }
}
