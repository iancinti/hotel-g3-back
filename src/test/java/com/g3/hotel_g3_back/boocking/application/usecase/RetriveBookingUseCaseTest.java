package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingRepository;
import com.g3.hotel_g3_back.booking.application.usecase.RetriveBookingUseCase;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RetriveBookingUseCaseTest {

    @Mock
    private RetriveBookingRepository retriveBookingRepository;

    @InjectMocks
    private RetriveBookingUseCase retriveBookingUseCase;

    @Test
    void execute_shouldReturnListOfBookings() {
        List<Booking> expectedBookings = Collections.singletonList(new Booking()); // Supongamos que esto crea una lista de una reserva.
        when(retriveBookingRepository.execute()).thenReturn(expectedBookings);

        List<Booking> result = retriveBookingUseCase.execute();

        assertEquals(expectedBookings, result, "The list of bookings returned should match the expected list");
        verify(retriveBookingRepository, times(1)).execute();
    }

    @Test
    void execute_shouldHandleEmptyList() {
        when(retriveBookingRepository.execute()).thenReturn(Collections.emptyList());

        List<Booking> result = retriveBookingUseCase.execute();

        assertTrue(result.isEmpty(), "The result should be an empty list of bookings");
        verify(retriveBookingRepository, times(1)).execute();
    }
}
