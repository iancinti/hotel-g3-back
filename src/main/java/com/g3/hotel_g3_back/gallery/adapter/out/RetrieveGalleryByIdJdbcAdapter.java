package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.share.exception.GenericException;
import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryByIdRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RetrieveGalleryByIdJdbcAdapter implements RetrieveGalleryByIdRepository {

    private final Logger log = LoggerFactory.getLogger(RetrieveGalleryByIdJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_IMAGES_BY_ID_SQL = "SELECT id_image, id_room, url_image, id_attraction FROM image WHERE id_room = ? OR id_attraction = ?";

    public RetrieveGalleryByIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Gallery execute(Integer idImage) {
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_IMAGES_BY_ID_SQL, idImage, idImage);

            if (rows.isEmpty()) {
                log.info("No se encontraron imágenes para el ID: {}", idImage);
                return new Gallery(idImage, null, null, new ArrayList<>());
            }

            List<String> imageUrls = new ArrayList<>();
            Integer idRoom = null;
            Integer idAttraction = null;

            for (Map<String, Object> row : rows) {
                if (idRoom == null) {
                    idRoom = (Integer) row.get("id_room");
                }
                if (idAttraction == null) {
                    idAttraction = (Integer) row.get("id_attraction");
                }
                imageUrls.add((String) row.get("url_image"));
            }

            return new Gallery(idImage, idRoom, idAttraction, imageUrls);
        } catch (EmptyResultDataAccessException e) {
            log.info("No se encontraron imágenes para el ID: {}", idImage);
            return new Gallery(idImage, null, null, new ArrayList<>());
        } catch (Exception e) {
            log.error("Error al recuperar la galería por ID: {}", e.getMessage());
            throw new GenericException("Error inesperado al recuperar la galería", e);
        }
    }
}
