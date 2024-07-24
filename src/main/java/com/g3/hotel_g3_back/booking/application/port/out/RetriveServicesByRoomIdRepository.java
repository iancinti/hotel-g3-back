package com.g3.hotel_g3_back.booking.application.port.out;

import java.util.List;

public interface RetriveServicesByRoomIdRepository {
    List<Integer> execute(String roomId);
}