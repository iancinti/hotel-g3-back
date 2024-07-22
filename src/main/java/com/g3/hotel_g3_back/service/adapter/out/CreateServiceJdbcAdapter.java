package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.CreateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateServiceJdbcAdapter implements CreateServiceRepository {

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
            System.out.println("Servicio creado: " + service);
        } catch (DataAccessException e) {
            System.out.println("Error al crear el servicio: " + e.getMessage());
        }
    }
}


