package com.g3.hotel_g3_back.booking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveRoomsQuery;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.application.port.out.RetriveServicesByRoomIdRepository;
import com.g3.hotel_g3_back.booking.domain.Room;
import com.g3.hotel_g3_back.share.Pagination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriveRoomsUseCase implements RetriveRoomsQuery {
    private final RetriveRoomsRepository retriveRoomsRepository;
    private final RetriveServicesByRoomIdRepository retriveServicesByRoomIdRepository;

    public RetriveRoomsUseCase(RetriveRoomsRepository retriveRoomsRepository, RetriveServicesByRoomIdRepository retriveServicesByRoomIdRepository) {
        this.retriveRoomsRepository = retriveRoomsRepository;
        this.retriveServicesByRoomIdRepository = retriveServicesByRoomIdRepository;
    }

    @Override
    public Pagination<Room> execute(int pageNumber, int pageSize, List<String> types, List<Integer> serviceIds) {

        Pagination<Room> result = retriveRoomsRepository.execute(pageNumber, pageSize, types, serviceIds);

        return new Pagination<>(
                result.getList()
                        .stream()
                        .peek(ro -> ro.setServices(
                                retriveServicesByRoomIdRepository.execute(ro.getIdRoom().toString())
                        )).toList(),
                result.getTotal()
        );
    }
}
