package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.DeleteServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class DeleteServiceJdbcAdapter implements DeleteServiceRepository {

    private final Logger log = LoggerFactory.getLogger(DeleteServiceJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    // Consulta SQL para hacer un soft delete
    private static final String SOFT_DELETE_SERVICE_SQL =
            "UPDATE service SET deleted_at = ? WHERE id = ?";

    @Autowired
    public DeleteServiceJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer id, Service service) {
        log.info("Intentando hacer un soft delete del servicio con ID: {}", id);

        try {
            // Crear un timestamp con la fecha y hora actuales
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());

            // Ejecutar la actualización para marcar el servicio como eliminado
            int rowsAffected = jdbcTemplate.update(SOFT_DELETE_SERVICE_SQL, now, id);

            if (rowsAffected > 0) {
                log.info("Servicio con ID: {} fue marcado como eliminado.", id);
            } else {
                log.info("No se encontró el servicio con ID: {}. Ningún registro fue actualizado.", id);
            }
        } catch (DataAccessException e) {
            log.error("Error al realizar soft delete del servicio con ID: {}: {}", id, e.getMessage());
            throw new GenericException("Error al realizar soft delete del servicio", e);
        }
    }
}


