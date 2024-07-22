package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.DeleteGalleryRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class DeleteGalleryJdbcAdapter implements DeleteGalleryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SOFT_DELETE_IMAGES_BY_ID_SQL = "UPDATE image SET deleted_at = ? WHERE id_room = ? OR id_attraction = ?";

    public DeleteGalleryJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer idImage) {
        try {
            Timestamp now = Timestamp.from(Instant.now());

            int rowsAffected = jdbcTemplate.update(SOFT_DELETE_IMAGES_BY_ID_SQL, now, idImage, idImage);

            if (rowsAffected > 0) {
                System.out.println("Galería marcada como eliminada con ID: " + idImage);
            } else {
                System.out.println("No se encontraron imágenes con ID de habitación o atracción: " + idImage);
            }
        } catch (DataAccessException e) {
            System.out.println("Error al marcar la galería como eliminada: " + e.getMessage());
        }
    }
}