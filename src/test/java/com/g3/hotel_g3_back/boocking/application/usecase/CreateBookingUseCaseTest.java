package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.CreateBookingRepository;
import com.g3.hotel_g3_back.booking.application.usecase.CreateBookingUseCase;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateBookingUseCaseTest {

    @Mock
    private CreateBookingRepository createBookingRepository;

    @InjectMocks
    private CreateBookingUseCase createBookingUseCase;

    @Test
    void execute_shouldInvokeCreateBookingRepository() {
        Booking booking = new Booking(); // Asumiendo que existe un constructor vacío o puedes usar uno que inicialice propiedades necesarias.

        createBookingUseCase.execute(booking);

        verify(createBookingRepository, times(1)).execute(booking);
    }

    @Test
    void execute_withValidBooking_shouldCompleteSuccessfully() {
        Booking booking = new Booking(); // Configura un objeto Booking con datos válidos.

        createBookingUseCase.execute(booking);

        verify(createBookingRepository).execute(booking);
    }
}
