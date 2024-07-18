package com.g3.hotel_g3_back.gallery.application.port.in;

import com.g3.hotel_g3_back.gallery.domain.Gallery;

public interface CreateGalleryCommand {
    void execute(Gallery gallery);
}
