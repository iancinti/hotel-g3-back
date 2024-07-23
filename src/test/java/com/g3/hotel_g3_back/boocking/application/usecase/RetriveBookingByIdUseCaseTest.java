package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.RetriveBookingByIdRepository;
import com.g3.hotel_g3_back.booking.application.usecase.RetriveBookingByIdUseCase;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RetriveBookingByIdUseCaseTest {

    @Mock
    private RetriveBookingByIdRepository retriveBookingByIdRepository;

    @InjectMocks
    private RetriveBookingByIdUseCase retriveBookingByIdUseCase;

    @Test
    void execute_shouldReturnBookingForValidId() {
        Integer bookingId = 1;
        Booking expectedBooking = new Booking(); // Configura un objeto Booking según necesites, tal vez con algunos datos mock.
        when(retriveBookingByIdRepository.execute(bookingId)).thenReturn(expectedBooking);

        Booking result = retriveBookingByIdUseCase.execute(bookingId);

        assertEquals(expectedBooking, result, "The booking retrieved should match the expected booking");
        verify(retriveBookingByIdRepository, times(1)).execute(bookingId);
    }

    @Test
    void execute_shouldReturnNullForInvalidId() {
        Integer invalidId = -1;
        when(retriveBookingByIdRepository.execute(invalidId)).thenReturn(null);

        Booking result = retriveBookingByIdUseCase.execute(invalidId);

        assertNull(result, "No booking should be retrieved for an invalid ID");
        verify(retriveBookingByIdRepository, times(1)).execute(invalidId);
    }
}
