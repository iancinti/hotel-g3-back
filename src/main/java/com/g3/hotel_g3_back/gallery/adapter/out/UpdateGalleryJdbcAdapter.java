package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.UpdateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpdateGalleryJdbcAdapter implements UpdateGalleryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String UPDATE_IMAGE_SQL = "UPDATE image SET id_room = ?, url_image = ?, id_attraction = ? WHERE id_image = ?";

    public UpdateGalleryJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer idImage, Gallery gallery) {
        try {
            for (String url : gallery.getImageUrl()) {
                jdbcTemplate.update(
                        UPDATE_IMAGE_SQL,
                        gallery.getIdRoom(),
                        url,
                        gallery.getIdAttraction(),
                        idImage
                );
            }
            System.out.println("Gallery updated successfully");
        } catch (Exception e) {
            System.out.println("Error updating gallery: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
