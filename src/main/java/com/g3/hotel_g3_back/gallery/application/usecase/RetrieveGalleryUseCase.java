package com.g3.hotel_g3_back.gallery.application.usecase;

import com.g3.hotel_g3_back.gallery.application.port.in.RetrieveGalleryQuery;
import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveGalleryUseCase implements RetrieveGalleryQuery {

    private final RetrieveGalleryRepository retrieveGalleryRepository;

    public RetrieveGalleryUseCase(RetrieveGalleryRepository retrieveGalleryRepository){
        this.retrieveGalleryRepository = retrieveGalleryRepository;
    }

    @Override
    public List<Gallery> execute() {
        return retrieveGalleryRepository.execute();
    }
}
