package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveBookingByIdQuery;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingByIdRepository;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.springframework.stereotype.Component;

@Component
public class RetriveBookingByIdUseCase implements RetriveBookingByIdQuery {

    private final RetriveBookingByIdRepository retriveBookingByIdRepository;

    public RetriveBookingByIdUseCase(RetriveBookingByIdRepository retriveBookingByIdRepository) {
        this.retriveBookingByIdRepository = retriveBookingByIdRepository;
    }

    @Override
    public Booking execute(String id) {
        return retriveBookingByIdRepository.execute(id);
    }
}

