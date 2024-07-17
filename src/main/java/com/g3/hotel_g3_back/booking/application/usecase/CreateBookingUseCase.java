package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.CreateBookingCommand;
import com.g3.hotel_g3_back.booking.application.port.out.CreateBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Component;

@Component
public class CreateBookingUseCase implements CreateBookingCommand {

    private final CreateBookingRepository createBookingRepository;

    public CreateBookingUseCase(CreateBookingRepository createBookingRepository) {
        this.createBookingRepository = createBookingRepository;
    }

    @Override
    public void execute(Booking booking) {
        createBookingRepository.execute(booking);
    }
}