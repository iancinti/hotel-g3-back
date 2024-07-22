package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.UpdateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UpdateAttractionUseCaseTest {

    @Mock
    private UpdateAttractionRepository updateAttractionRepository;

    @InjectMocks
    private UpdateAttractionUseCase updateAttractionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallRepositoryWithCorrectParameters() {
        Integer id = 1;
        Attraction attraction = new Attraction(id, "New Attraction", "New Description", "NewUrlImage");

        doNothing().when(updateAttractionRepository).execute(id, attraction);

        updateAttractionUseCase.execute(id, attraction);

        verify(updateAttractionRepository, times(1)).execute(id, attraction);
    }
}

