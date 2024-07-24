package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.CreateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateServiceJdbcAdapter implements CreateServiceRepository {

    private final Logger log = LoggerFactory.getLogger(CreateServiceJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_SERVICE_SQL = "INSERT INTO service (id, name, description, price) VALUES (?, ?, ?, ?)";

    public CreateServiceJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Service service) {
        try {
            jdbcTemplate.update(
                    INSERT_SERVICE_SQL,
                    service.getId(),
                    service.getName(),
                    service.getDescription(),
                    service.getPrice()
            );
            log.info("Servicio creado: {}", service);
        } catch (DataAccessException e) {
            log.error("Error al crear el servicio: {}", e.getMessage());
            throw new GenericException("Error al crear el servicio", e);
        }
    }
}



