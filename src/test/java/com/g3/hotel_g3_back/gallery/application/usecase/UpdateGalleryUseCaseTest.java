package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.out.UpdateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class UpdateGalleryUseCaseTest {

    @Mock
    private UpdateGalleryRepository updateGalleryRepository;

    @InjectMocks
    private UpdateGalleryUseCase updateGalleryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallRepositoryWithCorrectParameters() {
        Integer idImage = 1;
        Gallery gallery = new Gallery(idImage, 101, 201, List.of("url1", "url2"));

        updateGalleryUseCase.execute(idImage, gallery);

        verify(updateGalleryRepository, times(1)).execute(idImage, gallery);
    }
}
