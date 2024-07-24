package com.g3.hotel_g3_back.booking.application.port.in;

import com.g3.hotel_g3_back.booking.domain.Room;

public interface RetriveRoomByIdQuery {
    Room execute(Integer idRoom);
}
