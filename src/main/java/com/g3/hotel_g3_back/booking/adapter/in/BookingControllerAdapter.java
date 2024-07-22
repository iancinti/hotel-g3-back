package com.g3.hotel_g3_back.booking.adapter.in;

import com.g3.hotel_g3_back.booking.application.port.in.*;
import com.g3.hotel_g3_back.booking.domain.Booking;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(BookingControllerAdapter.class);

    private final RetriveBookingQuery retriveBookingQuery;
    private final RetriveBookingByIdQuery retriveBookingByIdQuery;
    private final RetriveRoomsQuery retriveRoomsQuery;
    private final CreateBookingCommand createBookingCommand;
    private final UpdateBookingCommand updateBookingCommand;
    private final DeleteBookingCommand deleteBookingCommand;


    public BookingControllerAdapter(RetriveBookingQuery retriveBookingQuery, RetriveBookingByIdQuery retriveBookingByIdQuery,
                                    RetriveRoomsQuery retriveRoomsQuery, CreateBookingCommand createBookingCommand, UpdateBookingCommand updateBookingCommand, DeleteBookingCommand deleteBookingCommand) {
        this.retriveBookingQuery = retriveBookingQuery;
        this.retriveBookingByIdQuery = retriveBookingByIdQuery;
        this.retriveRoomsQuery = retriveRoomsQuery;
        this.createBookingCommand = createBookingCommand;
        this.updateBookingCommand = updateBookingCommand;
        this.deleteBookingCommand = deleteBookingCommand;
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

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> retriveAllRooms(@RequestParam int pageNumber,@RequestParam int pageSize,
                                                      @RequestParam(required = false) Integer numberPeople,
                                                      @RequestParam(required = false) Double minPrice,
                                                      @RequestParam(required = false) Double maxPrice,
                                                      @RequestParam(required = false) String name){
        log.info("Se recibio una solicitud para obtener habitaciones");
        List<Room> response = retriveRoomsQuery.execute(pageNumber, pageSize, numberPeople, minPrice, maxPrice, name);
        log.info("Respondiendo con las Habitaciones");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Void> createBooking(@RequestBody Booking booking) {
        log.info("Se recibió una solicitud para crear una nueva reserva");
        createBookingCommand.execute(booking);
        log.info("Reserva creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable String id, @RequestBody Booking booking) {
        log.info("Se recibió una solicitud para actualizar la reserva con ID: " + id);
        updateBookingCommand.execute(id, booking);
        log.info("Reserva actualizada exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> softDeleteBooking(@PathVariable String id) {
        log.info("Se recibió una solicitud para eliminar lógicamente la reserva con ID: " + id);
        deleteBookingCommand.execute(id);
        log.info("Reserva eliminada lógicamente exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
