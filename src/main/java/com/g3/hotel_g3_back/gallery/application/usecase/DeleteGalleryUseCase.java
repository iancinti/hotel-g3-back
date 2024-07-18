package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.in.DeleteGalleryCommand;
import com.g3.hotel_g3_back.gallery.application.port.out.DeleteGalleryRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteGalleryUseCase implements DeleteGalleryCommand {

    private final DeleteGalleryRepository deleteGalleryRepository;

    public DeleteGalleryUseCase(DeleteGalleryRepository deleteGalleryRepository){
        this.deleteGalleryRepository = deleteGalleryRepository;
    }


    @Override
    public void execute(String id) {
        deleteGalleryRepository.execute(id);
    }
}
