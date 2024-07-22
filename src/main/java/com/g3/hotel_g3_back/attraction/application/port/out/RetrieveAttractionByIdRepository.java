package com.g3.hotel_g3_back.attraction.application.port.out;

import com.g3.hotel_g3_back.attraction.domain.Attraction;

public interface RetrieveAttractionByIdRepository {
    Attraction execute(Integer id);
}
