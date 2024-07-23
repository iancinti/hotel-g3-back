package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteAttractionUseCaseTest {

    @Mock
    private DeleteAttractionRepository deleteAttractionRepository;

    @InjectMocks
    private DeleteAttractionUseCase deleteAttractionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldDeleteAttraction() {
        Integer attractionId = 1;

        doNothing().when(deleteAttractionRepository).execute(attractionId);

        deleteAttractionUseCase.execute(attractionId);

        verify(deleteAttractionRepository, times(1)).execute(attractionId);
    }
}

