package com.g3.hotel_g3_back.attraction.application.port.in;

import com.g3.hotel_g3_back.attraction.domain.Attraction;

public interface UpdateAttractionCommand {
    void execute(Integer id, Attraction attraction);
}
