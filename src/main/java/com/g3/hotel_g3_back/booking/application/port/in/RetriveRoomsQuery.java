package com.g3.hotel_g3_back.booking.application.port.in;

import com.g3.hotel_g3_back.booking.domain.Room;

import java.util.List;

public interface RetriveRoomsQuery {
    List<Room> execute(int pageNumber, int pageSize, Integer numberPeople, Double minPrice, Double maxPrice, String name);
}
