package com.g3.hotel_g3_back.booking.application.port.out;

import com.g3.hotel_g3_back.booking.domain.Room;
import com.g3.hotel_g3_back.share.Pagination;

import java.util.List;

public interface RetriveRoomsRepository {
    Pagination<Room> execute(int pageNumber, int pageSize, List<String> types);
}
