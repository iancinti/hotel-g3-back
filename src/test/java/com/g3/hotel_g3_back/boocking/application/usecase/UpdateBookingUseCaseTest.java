package com.g3.hotel_g3_back.boocking.application.usecase;

import com.g3.hotel_g3_back.booking.application.port.out.UpdateBookingRepository;
import com.g3.hotel_g3_back.booking.application.usecase.UpdateBookingUseCase;
import com.g3.hotel_g3_back.booking.domain.Booking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateBookingUseCaseTest {

    @Mock
    private UpdateBookingRepository updateBookingRepository;

    @InjectMocks
    private UpdateBookingUseCase updateBookingUseCase;

    @Test
    void execute_shouldUpdateBooking() {
        Integer bookingId = 1;
        Booking booking = new Booking();  // Supone que Booking tiene un constructor adecuado o se inicializa de alguna manera.

        updateBookingUseCase.execute(bookingId, booking);

        verify(updateBookingRepository, times(1)).execute(bookingId, booking);
    }

    @Test
    void execute_withNullBooking_shouldNotThrowException() {
        Integer bookingId = 1;

        updateBookingUseCase.execute(bookingId, null);

        verify(updateBookingRepository, times(1)).execute(bookingId, null);
    }
}
