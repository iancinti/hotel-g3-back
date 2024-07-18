package com.g3.hotel_g3_back.attraction.adapter.in;

import com.g3.hotel_g3_back.attraction.application.port.in.*;
import com.g3.hotel_g3_back.booking.adapter.in.BookingControllerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attractions")
public class AttractionControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);

    private final RetrieveAttractionQuery retrieveAttractionQuery;
    private final RetrieveAttractionByIdQuery retrieveAttractionByIdQuery;
    private final UpdateAttractionCommand updateAttractionCommand;
    private final CreateAttractionCommand createAttractionCommand;
    private final DeleteAttractionCommand deleteAttractionCommand;

    public AttractionControllerAdapter(RetrieveAttractionQuery retrieveAttractionQuery,
                                       RetrieveAttractionByIdQuery retrieveAttractionByIdQuery,
                                       UpdateAttractionCommand updateAttractionCommand,
                                       CreateAttractionCommand createAttractionCommand,
                                       DeleteAttractionCommand deleteAttractionCommand){
        this.retrieveAttractionQuery = retrieveAttractionQuery;
        this.retrieveAttractionByIdQuery = retrieveAttractionByIdQuery;
        this.updateAttractionCommand = updateAttractionCommand;
        this.createAttractionCommand = createAttractionCommand;
        this.deleteAttractionCommand = deleteAttractionCommand;
    }
}
