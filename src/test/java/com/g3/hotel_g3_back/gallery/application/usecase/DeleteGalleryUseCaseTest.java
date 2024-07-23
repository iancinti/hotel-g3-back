package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.out.DeleteGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteGalleryUseCaseTest {

    @Mock
    private DeleteGalleryRepository deleteGalleryRepository;

    @InjectMocks
    private DeleteGalleryUseCase deleteGalleryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallDeleteGalleryRepository() {
        Integer idImage = 1;

        deleteGalleryUseCase.execute(idImage);

        verify(deleteGalleryRepository, times(1)).execute(idImage);
    }
}

