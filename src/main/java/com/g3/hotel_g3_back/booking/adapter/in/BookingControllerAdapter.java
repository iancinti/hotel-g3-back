package com.g3.hotel_g3_back.booking.adapter.in;

import com.g3.hotel_g3_back.booking.application.port.in.RetriveBookingByIdQuery;
import com.g3.hotel_g3_back.booking.application.port.in.RetriveBookingQuery;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(BookingControllerAdapter.class);

    private final RetriveBookingQuery retriveBookingQuery;
    private final RetriveBookingByIdQuery retriveBookingByIdQuery;

    public BookingControllerAdapter(RetriveBookingQuery retriveBookingQuery, RetriveBookingByIdQuery retriveBookingByIdQuery) {
        this.retriveBookingQuery = retriveBookingQuery;
        this.retriveBookingByIdQuery = retriveBookingByIdQuery;
    }

    @GetMapping()
    public ResponseEntity<List<Booking>> getBookings() {
        log.info("Se recibió una solicitud para obtener las reservas");
        List<Booking> response = retriveBookingQuery.execute();
        log.info("Respondiendo con las reservas");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
        log.info("Se recibió una solicitud para obtener la reserva con ID: " + id);
        Booking response = retriveBookingByIdQuery.execute(id);
        log.info("Respondiendo con la reserva");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
