package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetrieveGalleryUseCaseTest {

    @Mock
    private RetrieveGalleryRepository retrieveGalleryRepository;

    @InjectMocks
    private RetrieveGalleryUseCase retrieveGalleryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnEmptyListWhenNoGalleryExists() {
        when(retrieveGalleryRepository.execute()).thenReturn(List.of());

        List<Gallery> result = retrieveGalleryUseCase.execute();

        verify(retrieveGalleryRepository, times(1)).execute();
        assertEquals(List.of(), result);
    }

    @Test
    void execute_shouldReturnListOfGalleries() {
        Gallery gallery1 = new Gallery(1, 101, 201, List.of("url1"));
        Gallery gallery2 = new Gallery(2, 102, 202, List.of("url2"));
        List<Gallery> expectedGalleries = List.of(gallery1, gallery2);
        when(retrieveGalleryRepository.execute()).thenReturn(expectedGalleries);

        List<Gallery> result = retrieveGalleryUseCase.execute();

        verify(retrieveGalleryRepository, times(1)).execute();
        assertEquals(expectedGalleries, result);
    }
}

