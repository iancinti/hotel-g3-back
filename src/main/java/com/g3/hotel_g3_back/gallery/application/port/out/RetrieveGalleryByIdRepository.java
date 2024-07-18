package com.g3.hotel_g3_back.gallery.application.port.out;

import com.g3.hotel_g3_back.gallery.domain.Gallery;

public interface RetrieveGalleryByIdRepository {
    Gallery execute(String id);
}
