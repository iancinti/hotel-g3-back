package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetrieveAttractionUseCaseTest {

    @Mock
    private RetrieveAttractionRepository retrieveAttractionRepository;

    @InjectMocks
    private RetrieveAttractionUseCase retrieveAttractionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnListOfAttractions() {
        List<Attraction> expectedAttractions = Collections.singletonList(new Attraction(1, "Jardin Japones", "Lorem ipsum dolor sit amet", "urlImage"));

        when(retrieveAttractionRepository.execute()).thenReturn(expectedAttractions);

        List<Attraction> result = retrieveAttractionUseCase.execute();

        assertEquals(expectedAttractions, result);
        verify(retrieveAttractionRepository, times(1)).execute();
    }
}

