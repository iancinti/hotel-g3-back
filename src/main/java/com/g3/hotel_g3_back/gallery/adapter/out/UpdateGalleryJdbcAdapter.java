package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.UpdateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;

public class UpdateGalleryJdbcAdapter implements UpdateGalleryRepository {
    @Override
    public void execute(String id, Gallery gallery) {
        System.out.println("Actualizacion de la galeria con ID: " + id);
    }
}
