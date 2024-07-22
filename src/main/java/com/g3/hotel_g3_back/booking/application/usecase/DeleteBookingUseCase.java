package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.DeleteBookingCommand;
import com.g3.hotel_g3_back.booking.application.port.out.DeleteBookingRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookingUseCase implements DeleteBookingCommand {

    private final DeleteBookingRepository deleteBookingRepository;

    public DeleteBookingUseCase(DeleteBookingRepository deleteBookingRepository) {
        this.deleteBookingRepository = deleteBookingRepository;
    }

    @Override
    public void execute(Integer id) {
        deleteBookingRepository.execute(id);
    }
}


