package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveRoomsQuery;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RetriveRoomsUseCase implements RetriveRoomsQuery {
    private final RetriveRoomsRepository retriveRoomsRepository;

    public RetriveRoomsUseCase(RetriveRoomsRepository retriveRoomsRepository) {
        this.retriveRoomsRepository = retriveRoomsRepository;
    }

    @Override
    public List<Room> execute(int pageNumber, int pageSize) {
        return retriveRoomsRepository.execute(pageNumber, pageSize);
    }
}