package com.g3.hotel_g3_back.gallery.adapter.in;

import com.g3.hotel_g3_back.gallery.application.port.in.*;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GalleryControllerAdapterTest {

    @Mock
    private RetrieveGalleryQuery retrieveGalleryQuery;

    @Mock
    private RetrieveGalleryByIdQuery retrieveGalleryByIdQuery;

    @Mock
    private CreateGalleryCommand createGalleryCommand;

    @Mock
    private UpdateGalleryCommand updateGalleryCommand;

    @Mock
    private DeleteGalleryCommand deleteGalleryCommand;

    @InjectMocks
    private GalleryControllerAdapter galleryControllerAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getGalleryImages_shouldReturnListOfGalleryImages() {
        Gallery gallery = new Gallery(1, 1, 1, Arrays.asList("url1", "url2"));
        List<Gallery> galleries = Collections.singletonList(gallery);
        when(retrieveGalleryQuery.execute()).thenReturn(galleries);

        ResponseEntity<List<Gallery>> response = galleryControllerAdapter.getGalleryImages();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(galleries, response.getBody());
        verify(retrieveGalleryQuery, times(1)).execute();
    }

    @Test
    void getGalleryImageById_shouldReturnGalleryImage() {
        Gallery gallery = new Gallery(1, 1, 1, Arrays.asList("url1", "url2"));
        when(retrieveGalleryByIdQuery.execute(1)).thenReturn(gallery);

        ResponseEntity<Gallery> response = galleryControllerAdapter.getGalleryImageById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gallery, response.getBody());
        verify(retrieveGalleryByIdQuery, times(1)).execute(1);
    }

    @Test
    void createGallery_shouldReturnCreatedStatus() {
        Gallery gallery = new Gallery(1, 1, 1, Arrays.asList("url1", "url2"));
        doNothing().when(createGalleryCommand).execute(gallery);

        ResponseEntity<Void> response = galleryControllerAdapter.createGallery(gallery);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(createGalleryCommand, times(1)).execute(gallery);
    }

    @Test
    void updateGallery_shouldReturnNoContentStatus() {
        Gallery gallery = new Gallery(1, 1, 1, Arrays.asList("url1", "url2"));
        doNothing().when(updateGalleryCommand).execute(1, gallery);

        ResponseEntity<Void> response = galleryControllerAdapter.updateGallery(1, gallery);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(updateGalleryCommand, times(1)).execute(1, gallery);
    }

    @Test
    void deleteGallery_shouldReturnNoContentStatus() {
        doNothing().when(deleteGalleryCommand).execute(1);

        ResponseEntity<Void> response = galleryControllerAdapter.deleteGallery(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleteGalleryCommand, times(1)).execute(1);
    }
}


