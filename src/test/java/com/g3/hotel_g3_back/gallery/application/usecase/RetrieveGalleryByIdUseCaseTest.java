package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryByIdRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetrieveGalleryByIdUseCaseTest {

    @Mock
    private RetrieveGalleryByIdRepository retrieveGalleryByIdRepository;

    @InjectMocks
    private RetrieveGalleryByIdUseCase retrieveGalleryByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnGalleryWithEmptyImageUrlList() {
        Integer idImage = 1;
        Gallery expectedGallery = new Gallery(idImage, 101, 201, List.of());
        when(retrieveGalleryByIdRepository.execute(idImage)).thenReturn(expectedGallery);

        Gallery result = retrieveGalleryByIdUseCase.execute(idImage);

        verify(retrieveGalleryByIdRepository, times(1)).execute(idImage);
        assertEquals(expectedGallery, result);
    }
}

