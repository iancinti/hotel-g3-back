package com.g3.hotel_g3_back.boocking.adapter.in;

import com.g3.hotel_g3_back.booking.adapter.in.BookingControllerAdapter;
import com.g3.hotel_g3_back.booking.application.port.in.*;
import com.g3.hotel_g3_back.booking.domain.Booking;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class BookingControllerAdapterTest {
    @Mock
    private RetriveBookingQuery retriveBookingQuery;

    @Mock
    private RetriveBookingByIdQuery retriveBookingByIdQuery;

    @Mock
    private RetriveRoomsQuery retriveRoomsQuery;

    @Mock
    private CreateBookingCommand createBookingCommand;

    @Mock
    private UpdateBookingCommand updateBookingCommand;

    @Mock
    private DeleteBookingCommand deleteBookingCommand;

    @InjectMocks
    private BookingControllerAdapter bookingControllerAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBookings_shouldReturnListOfBookings() {
        List<Booking> bookings = Collections.singletonList(new Booking());
        when(retriveBookingQuery.execute()).thenReturn(bookings);

        ResponseEntity<List<Booking>> response = bookingControllerAdapter.getBookings();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookings, response.getBody());
        verify(retriveBookingQuery, times(1)).execute();
    }

    @Test
    void getBookingById_shouldReturnBooking() {
        Booking booking = new Booking();
        when(retriveBookingByIdQuery.execute(1)).thenReturn(booking);

        ResponseEntity<Booking> response = bookingControllerAdapter.getBookingById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(booking, response.getBody());
        verify(retriveBookingByIdQuery, times(1)).execute(1);
    }

    @Test
    void retriveAllRooms_shouldReturnListOfRooms() {
        List<Room> rooms = Collections.singletonList(new Room());
        when(retriveRoomsQuery.execute(1, 10, null, null, null, null)).thenReturn(rooms);

        ResponseEntity<List<Room>> response = bookingControllerAdapter.retriveAllRooms(1, 10, null, null, null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rooms, response.getBody());
        verify(retriveRoomsQuery, times(1)).execute(1, 10, null, null, null, null);
    }

    @Test
    void createBooking_shouldReturnCreatedStatus() {
        Booking booking = new Booking();
        doNothing().when(createBookingCommand).execute(booking);

        ResponseEntity<Void> response = bookingControllerAdapter.createBooking(booking);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(createBookingCommand, times(1)).execute(booking);
    }

    @Test
    void updateBooking_shouldReturnNoContentStatus() {
        Booking booking = new Booking();
        doNothing().when(updateBookingCommand).execute(1, booking);

        ResponseEntity<Void> response = bookingControllerAdapter.updateBooking(1, booking);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(updateBookingCommand, times(1)).execute(1, booking);
    }

    @Test
    void softDeleteBooking_shouldReturnNoContentStatus() {
        doNothing().when(deleteBookingCommand).execute(1);

        ResponseEntity<Void> response = bookingControllerAdapter.softDeleteBooking(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleteBookingCommand, times(1)).execute(1);
    }
}