package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.DeleteGalleryRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteGalleryJdbcAdapter implements DeleteGalleryRepository {
    @Override
    public void execute(String id) {
        System.out.println("Eliminacion de la galeria con ID: " + id);
    }
}
