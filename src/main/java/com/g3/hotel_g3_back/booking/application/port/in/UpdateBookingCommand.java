package com.g3.hotel_g3_back.booking.application.port.in;

import com.g3.hotel_g3_back.booking.domain.Booking;

public interface UpdateBookingCommand {
    void execute(Integer id, Booking booking);
}