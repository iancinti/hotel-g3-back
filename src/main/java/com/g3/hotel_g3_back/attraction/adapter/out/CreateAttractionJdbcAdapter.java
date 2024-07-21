package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.CreateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateAttractionJdbcAdapter implements CreateAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);

    @Override
    public void execute(Attraction attraction) {
        log.info("Se crea la atraccion de forma exitosa");
    }
}
