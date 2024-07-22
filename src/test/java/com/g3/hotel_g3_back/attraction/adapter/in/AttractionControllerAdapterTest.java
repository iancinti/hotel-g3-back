package com.g3.hotel_g3_back.attraction.adapter.in;

import com.g3.hotel_g3_back.attraction.application.port.in.*;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AttractionControllerAdapterTest {

    @Mock
    private RetrieveAttractionQuery retrieveAttractionQuery;

    @Mock
    private RetrieveAttractionByIdQuery retrieveAttractionByIdQuery;

    @Mock
    private UpdateAttractionCommand updateAttractionCommand;

    @Mock
    private CreateAttractionCommand createAttractionCommand;

    @Mock
    private DeleteAttractionCommand deleteAttractionCommand;

    @InjectMocks
    private AttractionControllerAdapter attractionControllerAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAttractions_shouldReturnListOfAttractions() {
        List<Attraction> attractions = Arrays.asList(
                new Attraction(1, "Attraction 1", "Description 1", "urlImage1"),
                new Attraction(2, "Attraction 2", "Description 2", "urlImage2")
        );
        when(retrieveAttractionQuery.execute()).thenReturn(attractions);

        ResponseEntity<List<Attraction>> response = attractionControllerAdapter.getAttractions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(attractions, response.getBody());
        verify(retrieveAttractionQuery, times(1)).execute();
    }

    @Test
    void getAttractionById_shouldReturnAttraction() {
        Attraction attraction = new Attraction(1, "Attraction 1", "Description 1", "urlImage1");
        when(retrieveAttractionByIdQuery.execute(1)).thenReturn(attraction);

        ResponseEntity<Attraction> response = attractionControllerAdapter.getAttractionById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(attraction, response.getBody());
        verify(retrieveAttractionByIdQuery, times(1)).execute(1);
    }

    @Test
    void createAttraction_shouldReturnCreatedStatus() {
        Attraction attraction = new Attraction(1, "Attraction 1", "Description 1", "urlImage1");
        doNothing().when(createAttractionCommand).execute(attraction);

        ResponseEntity<Void> response = attractionControllerAdapter.createAttraction(attraction);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(createAttractionCommand, times(1)).execute(attraction);
    }

    @Test
    void updateAttraction_shouldReturnNoContentStatus() {
        Attraction attraction = new Attraction(1, "Attraction 1", "Description 1", "urlImage1");
        doNothing().when(updateAttractionCommand).execute(1, attraction);

        ResponseEntity<Void> response = attractionControllerAdapter.updateAttraction(1, attraction);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(updateAttractionCommand, times(1)).execute(1, attraction);
    }

    @Test
    void softDeleteAttraction_shouldReturnNoContentStatus() {
        doNothing().when(deleteAttractionCommand).execute(1);

        ResponseEntity<Void> response = attractionControllerAdapter.softDeleteAttraction(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleteAttractionCommand, times(1)).execute(1);
    }
}


