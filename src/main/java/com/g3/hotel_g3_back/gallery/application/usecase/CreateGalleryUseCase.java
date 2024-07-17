package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.in.CreateGalleryCommand;
import com.g3.hotel_g3_back.gallery.application.port.out.CreateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

@Component
public class CreateGalleryUseCase implements CreateGalleryCommand {

    private final CreateGalleryRepository createGalleryRepository;

    public CreateGalleryUseCase(CreateGalleryRepository createGalleryRepository){
        this.createGalleryRepository = createGalleryRepository;
    }

    @Override
    public void execute(Gallery gallery) {
        createGalleryRepository.execute(gallery);
    }
}
