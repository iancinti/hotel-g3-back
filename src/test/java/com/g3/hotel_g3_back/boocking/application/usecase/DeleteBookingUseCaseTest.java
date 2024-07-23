package com.g3.hotel_g3_back.boocking.application.usecase;
import com.g3.hotel_g3_back.booking.application.port.out.DeleteBookingRepository;
import com.g3.hotel_g3_back.booking.application.usecase.DeleteBookingUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteBookingUseCaseTest {

    @Mock
    private DeleteBookingRepository deleteBookingRepository;

    @InjectMocks
    private DeleteBookingUseCase deleteBookingUseCase;

    @Test
    void execute_shouldCallDeleteBookingRepository() {
        Integer bookingId = 1;

        deleteBookingUseCase.execute(bookingId);

        verify(deleteBookingRepository, times(1)).execute(bookingId);
    }

    @Test
    void execute_withInvalidId_shouldStillCallDeleteBookingRepository() {
        Integer invalidBookingId = -1;

        deleteBookingUseCase.execute(invalidBookingId);

        verify(deleteBookingRepository).execute(invalidBookingId);
    }
}