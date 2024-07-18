package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetrieveGalleryJdbcAdapter implements RetrieveGalleryRepository {
    @Override
    public List<Gallery> execute() {
        return Arrays.asList(
                new Gallery(1, "Suite", new ArrayList<String>(Arrays.asList("urlImagen1","urlImagen2"))),
                new Gallery(2, "Simple", new ArrayList<String>(Arrays.asList("urlImagen1","urlImagen2")))
        );
    }
}
