package com.g3.hotel_g3_back.gallery.application.port.out;

import com.g3.hotel_g3_back.gallery.domain.Gallery;

public interface UpdateGalleryRepository {
    void execute(String id, Gallery gallery);
}
