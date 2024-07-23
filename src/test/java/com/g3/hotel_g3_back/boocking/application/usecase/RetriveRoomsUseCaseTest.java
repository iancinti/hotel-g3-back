package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomsRepository;
import com.g3.hotel_g3_back.booking.application.usecase.RetriveRoomsUseCase;
import com.g3.hotel_g3_back.booking.domain.Room;
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
        List<Room> rooms = Collections.singletonList(new Room());
        when(retriveRoomsRepository.execute(1, 10, null, null, null, null)).thenReturn(rooms);

        List<Room> result = retriveRoomsUseCase.execute(1, 10, null, null, null, null);

        assertEquals(rooms, result);
        verify(retriveRoomsRepository, times(1)).execute(1, 10, null, null, null, null);
    }

    @Test
    void execute_withParameters_shouldReturnListOfRooms() {
        List<Room> rooms = Collections.singletonList(new Room());
        when(retriveRoomsRepository.execute(1, 10, 2, 100.0, 200.0, 1)).thenReturn(rooms);

        List<Room> result = retriveRoomsUseCase.execute(1, 10, 2, 100.0, 200.0, 1);

        assertEquals(rooms, result);
        verify(retriveRoomsRepository, times(1)).execute(1, 10, 2, 100.0, 200.0, 1);
    }
}