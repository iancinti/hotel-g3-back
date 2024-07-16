package com.g3.hotel_g3_back.booking.adapter.in;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveBookingQuery;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(BookingControllerAdapter.class);
    private final RetriveBookingQuery retriveBookingQuery;

    public BookingControllerAdapter(RetriveBookingQuery retriveBookingQuery) {
        this.retriveBookingQuery = retriveBookingQuery;
    }

    @GetMapping()
    public ResponseEntity<Booking> getBooking() {
        log.info("Se recibió una solicitud para obtener la reserva");
        Booking response = retriveBookingQuery.execute();
        log.info("Respondiendo con la reserva");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
