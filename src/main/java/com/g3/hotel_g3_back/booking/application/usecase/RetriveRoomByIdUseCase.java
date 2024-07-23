package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveRoomByIdQuery;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomByIdRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.springframework.stereotype.Component;

@Component
public class RetriveRoomByIdUseCase implements RetriveRoomByIdQuery {

    private final RetriveRoomByIdRepository retriveRoomByIdRepository;

    public RetriveRoomByIdUseCase(RetriveRoomByIdRepository retriveRoomByIdRepository) {
        this.retriveRoomByIdRepository = retriveRoomByIdRepository;
    }

    @Override
    public Room execute(Integer idRoom) {
        return retriveRoomByIdRepository.execute(idRoom);
    }
}

