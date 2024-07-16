package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveBookingQuery;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Component;

@Component
public class RetriveBookingUseCase implements RetriveBookingQuery {

    private final RetriveBookingRepository retriveBookingRepository;

    public RetriveBookingUseCase(RetriveBookingRepository retriveBookingRepository) {
        this.retriveBookingRepository = retriveBookingRepository;
    }

    @Override
    public Booking execute() {
        return retriveBookingRepository.execute();
    }
}
