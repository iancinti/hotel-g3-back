package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.CreateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

@Component
public class CreateGalleryJdbcAdapter implements CreateGalleryRepository {
    @Override
    public void execute(Gallery gallery) {
        System.out.println("Galeria creada");
    }
}
