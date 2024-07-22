package com.g3.hotel_g3_back.booking.application.port.out;

import com.g3.hotel_g3_back.booking.domain.Room;

import java.util.List;

public interface RetriveRoomsRepository {
    List<Room> execute(int pageNumber, int pageSize, List<String> types);
}
