package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.UpdateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateAttractionJdbcAdapter implements UpdateAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);

    @Override
    public void execute(String id, Attraction attraction) {
        log.info("Atraccion actualizada con el ID: " + id);
    }
}
