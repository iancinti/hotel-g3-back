package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.out.CreateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class CreateGalleryUseCaseTest {

    @Mock
    private CreateGalleryRepository createGalleryRepository;

    @InjectMocks
    private CreateGalleryUseCase createGalleryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallCreateGalleryRepository() {
        Gallery gallery = new Gallery(1, 2, 3, List.of("url1", "url2"));

        createGalleryUseCase.execute(gallery);

        verify(createGalleryRepository, times(1)).execute(gallery);
    }
}


