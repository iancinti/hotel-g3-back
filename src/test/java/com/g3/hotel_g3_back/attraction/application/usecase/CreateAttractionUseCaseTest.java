package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.CreateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CreateAttractionUseCaseTest {

    @Mock
    private CreateAttractionRepository createAttractionRepository;

    @InjectMocks
    private CreateAttractionUseCase createAttractionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCreateAttraction() {
        Attraction attraction = new Attraction(1, "Attraction 1", "Description 1", "urlImage1");

        doNothing().when(createAttractionRepository).execute(attraction);

        createAttractionUseCase.execute(attraction);

        verify(createAttractionRepository, times(1)).execute(attraction);
    }
}

