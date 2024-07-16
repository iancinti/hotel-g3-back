package com.g3.hotel_g3_back.booking.application.port.out;

import com.g3.hotel_g3_back.booking.domain.Booking;

import java.util.List;

public interface RetriveBookingRepository {
    List<Booking> execute();
}

