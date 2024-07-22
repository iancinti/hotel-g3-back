package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DeleteAttractionJdbcAdapter implements DeleteAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String SOFT_DELETE_IMAGES_BY_ATTRACTION_SQL = "UPDATE image SET deleted_at = ? WHERE id_attraction = ?";
    private static final String SOFT_DELETE_ATTRACTION_SQL = "UPDATE attraction SET deleted_at = ? WHERE id_attraction = ?";

    @Autowired
    public DeleteAttractionJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id) {
        log.info("Intentando marcar como eliminada la atracción con ID: " + id);
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());

        try {
            int imagesUpdated = jdbcTemplate.update(SOFT_DELETE_IMAGES_BY_ATTRACTION_SQL, now, id);
            log.info("Imágenes marcadas como eliminadas: {}", imagesUpdated);

            int rowsAffected = jdbcTemplate.update(SOFT_DELETE_ATTRACTION_SQL, now, id);
            if (rowsAffected > 0) {
                log.info("Atracción marcada como eliminada con éxito.");
            } else {
                log.info("No se encontró la atracción con ID: {}, no se marcó nada.", id);
            }
        } catch (DataAccessException e) {
            log.error("Error al marcar la atracción y sus imágenes como eliminadas: {}", e.getMessage());
            throw e;
        }
    }
}
