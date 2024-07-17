package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.UpdateBookingCommand;
import com.g3.hotel_g3_back.booking.application.port.out.UpdateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Component;

@Component
public class UpdateBookingUseCase implements UpdateBookingCommand {

    private final UpdateBookingRepository updateBookingRepository;

    public UpdateBookingUseCase(UpdateBookingRepository updateBookingRepository) {
        this.updateBookingRepository = updateBookingRepository;
    }

    @Override
    public void execute(String id, Booking booking) {
        updateBookingRepository.execute(id, booking);
    }
}

