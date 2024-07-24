package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveRoomByIdRepository;
import com.g3.hotel_g3_back.booking.application.usecase.RetriveRoomByIdUseCase;
import com.g3.hotel_g3_back.booking.domain.Room;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RetriveRoomByIdUseCaseTest {

    @Mock
    private RetriveRoomByIdRepository retriveRoomByIdRepository;

    @InjectMocks
    private RetriveRoomByIdUseCase retriveRoomByIdUseCase;

    @Test
    void execute_shouldReturnRoomForValidId() {
        Integer roomID = 1;
        Room expectedRoom = new Room(); // Asume que Room tiene un constructor adecuado o se inicializa de alguna manera.
        when(retriveRoomByIdRepository.execute(roomID)).thenReturn(expectedRoom);

        Room result = retriveRoomByIdUseCase.execute(roomID);

        assertEquals(expectedRoom, result, "The room retrieved should match the expected room");
        verify(retriveRoomByIdRepository, times(1)).execute(roomID);
    }

    @Test
    void execute_shouldReturnNullForInvalidId() {
        Integer invalidRoomId = -1;
        when(retriveRoomByIdRepository.execute(invalidRoomId)).thenReturn(null);

        Room result = retriveRoomByIdUseCase.execute(invalidRoomId);

        assertNull(result, "No room should be retrieved for an invalid ID");
        verify(retriveRoomByIdRepository, times(1)).execute(invalidRoomId);
    }
}
