package com.g3.hotel_g3_back.booking.application.port.out;

import com.g3.hotel_g3_back.booking.domain.Booking;

public interface RetriveBookingByIdRepository {
    Booking execute(String id);
}