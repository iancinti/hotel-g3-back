package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryByIdRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class RetrieveGalleryByIdJdbcAdapter implements RetrieveGalleryByIdRepository {
    @Override
    public Gallery execute(String id) {
        return new Gallery(1, "Suite", new ArrayList<>(Arrays.asList("urlImagen1", "urlImagen2")));
    }
}
