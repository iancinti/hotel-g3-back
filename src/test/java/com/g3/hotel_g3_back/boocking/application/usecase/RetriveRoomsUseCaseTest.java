package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.application.usecase.RetriveRoomsUseCase;
import com.g3.hotel_g3_back.booking.domain.Room;
import com.g3.hotel_g3_back.share.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetriveRoomsUseCaseTest {

    @Mock
    private RetriveRoomsRepository retriveRoomsRepository;

    @InjectMocks
    private RetriveRoomsUseCase retriveRoomsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnListOfRooms() {
        Room room = new Room();
        room.setIdRoom(1);
        room.setName("Habitación Estándar");
        room.setPrice(100.0);
        room.setNumberPeople(2);
        room.setType("SIMPLE");
        Pagination<Room> rooms = new Pagination<>(Collections.singletonList(room), 1);

        when(retriveRoomsRepository.execute(1, 10, List.of(), List.of())).thenReturn(rooms);

        Pagination<Room> result = retriveRoomsUseCase.execute(1, 10, List.of(), List.of());

        assertEquals(rooms, result);
        verify(retriveRoomsRepository, times(1)).execute(1, 10, List.of(), List.of());
    }

    @Test
    void execute_withParameters_shouldReturnListOfRooms() {
        Room room = new Room();
        room.setIdRoom(2);
        room.setName("Habitación Deluxe");
        room.setPrice(200.0);
        room.setNumberPeople(2);
        room.setType("DOBLE");
        Pagination<Room> rooms = new Pagination<>(Collections.singletonList(room), 1);

        List<String> types = List.of("DOBLE");
        List<Integer> serviceIds = List.of(1, 2);

        when(retriveRoomsRepository.execute(1, 10, types, serviceIds)).thenReturn(rooms);

        Pagination<Room> result = retriveRoomsUseCase.execute(1, 10, types, serviceIds);

        assertEquals(rooms, result);
        verify(retriveRoomsRepository, times(1)).execute(1, 10, types, serviceIds);
    }
}