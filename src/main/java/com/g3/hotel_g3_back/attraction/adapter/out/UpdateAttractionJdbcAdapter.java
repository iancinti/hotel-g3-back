package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.UpdateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpdateAttractionJdbcAdapter implements UpdateAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String UPDATE_ATTRACTION_SQL = "UPDATE attraction SET name = ?, description = ? WHERE id_attraction = ?";

    @Autowired
    public UpdateAttractionJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id, Attraction attraction) {
        log.info("Intentando actualizar la atracción con el ID: " + id);
        try {
            int rowsAffected = jdbcTemplate.update(UPDATE_ATTRACTION_SQL,
                    attraction.getName(),
                    attraction.getDescription(),
                    id);

            if (rowsAffected > 0) {
                log.info("Atracción actualizada con éxito.");
            } else {
                log.info("No se encontró la atracción con ID: {}, no se actualizó nada.", id);
            }
        } catch (DataAccessException e) {
            log.error("Error al actualizar la atracción: {}", e.getMessage());
            throw e;
        }
    }
}
