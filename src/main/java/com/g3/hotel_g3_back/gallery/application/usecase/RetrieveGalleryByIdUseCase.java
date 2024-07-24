package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.in.RetrieveGalleryByIdQuery;
import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryByIdRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

@Component
public class RetrieveGalleryByIdUseCase implements RetrieveGalleryByIdQuery {

    private final RetrieveGalleryByIdRepository retrieveGalleryByIdRepository;

    public RetrieveGalleryByIdUseCase(RetrieveGalleryByIdRepository retrieveGalleryByIdRepository){
        this.retrieveGalleryByIdRepository = retrieveGalleryByIdRepository;
    }

    @Override
    public Gallery execute(Integer idImage) {
        return retrieveGalleryByIdRepository.execute(idImage);
    }
}
