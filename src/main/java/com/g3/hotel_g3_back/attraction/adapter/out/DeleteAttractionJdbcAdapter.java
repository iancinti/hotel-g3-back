package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeleteAttractionJdbcAdapter implements DeleteAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);

    @Override
    public void execute(String id) {
        log.info("Atraccion eliminada con el ID: " + id);
    }
}
