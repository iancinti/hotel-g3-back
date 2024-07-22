package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeleteAttractionJdbcAdapter implements DeleteAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String DELETE_IMAGES_BY_ATTRACTION_SQL = "DELETE FROM Image WHERE id_attraction = ?";
    private static final String DELETE_ATTRACTION_SQL = "DELETE FROM Attraction WHERE id_attraction = ?";
    @Autowired
    public DeleteAttractionJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id) {
        log.info("Atraccion eliminada con el ID: " + id);
        try {
            // Eliminar imágenes asociadas con la atracción
            int imagesDeleted = jdbcTemplate.update(DELETE_IMAGES_BY_ATTRACTION_SQL, id);
            log.info("Imágenes eliminadas: {}", imagesDeleted);

            // Eliminar atracción
            int rowsAffected = jdbcTemplate.update(DELETE_ATTRACTION_SQL, id);
            if (rowsAffected > 0) {
                log.info("Atracción eliminada con éxito.");
            } else {
                log.info("No se encontró la atracción con ID: {}, no se eliminó nada.", id);
            }
        } catch (DataAccessException e) {
            log.error("Error al eliminar la atracción y sus imágenes: {}", e.getMessage());
            // La anotación @Transactional asegura que se haga rollback si ocurre una excepción
            throw e;
        }

    }
}
