package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionByIdRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetrieveAttractionByIdUseCaseTest {

    @Mock
    private RetrieveAttractionByIdRepository retrieveAttractionByIdRepository;

    @InjectMocks
    private RetrieveAttractionByIdUseCase retrieveAttractionByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnAttraction() {
        Integer attractionId = 1;
        Attraction expectedAttraction = new Attraction(1, "Jardin Japones", "Lorem ipsum dolor sit amet", "urlImage");

        when(retrieveAttractionByIdRepository.execute(attractionId)).thenReturn(expectedAttraction);

        Attraction result = retrieveAttractionByIdUseCase.execute(attractionId);

        assertEquals(expectedAttraction, result);
        verify(retrieveAttractionByIdRepository, times(1)).execute(attractionId);
    }
}
