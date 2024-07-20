package com.g3.hotel_g3_back.attraction.application.port.in;

import com.g3.hotel_g3_back.attraction.domain.Attraction;

import java.util.List;

public interface RetrieveAttractionQuery {
    List<Attraction> execute();
}
