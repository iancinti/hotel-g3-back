package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.in.UpdateGalleryCommand;
import com.g3.hotel_g3_back.gallery.application.port.out.UpdateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

@Component
public class UpdateGalleryUseCase implements UpdateGalleryCommand {

    private final UpdateGalleryRepository updateGalleryRepository;

    public UpdateGalleryUseCase(UpdateGalleryRepository updateGalleryRepository){
        this.updateGalleryRepository = updateGalleryRepository;
    }

    @Override
    public void execute(String id, Gallery gallery) {
        updateGalleryRepository.execute(id, gallery);
    }
}
