package com.g3.hotel_g3_back.attraction.application.port.out;

import com.g3.hotel_g3_back.attraction.domain.Attraction;

import java.util.List;

public interface RetrieveAttractionRepository {
    List<Attraction> execute();
}
