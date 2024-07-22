package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.UpdateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateServiceJdbcAdapter implements UpdateServiceRepository {

    private JdbcTemplate jdbcTemplate;


    private static final String UPDATE_SERVICE_SQL = "UPDATE service SET name = ?, description = ?, price = ? WHERE id = ?";

    public UpdateServiceJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(String id, Service service){
        try {
            int rowsUpdated = jdbcTemplate.update(
                    UPDATE_SERVICE_SQL,
                    service.getName(),
                    service.getDescription(),
                    service.getPrice(),
                    service.getId() // Asegúrate de pasar el ID como último parámetro según la consulta SQL definida.
            );
            if (rowsUpdated > 0) {
                System.out.println("Servicio actualizado: " + service);
            } else {
                System.out.println("No se encontró el servicio con ID: " + service.getId() + " para actualizar.");
            }
        } catch (DataAccessException e) {
            System.out.println("Error al actualizar el servicio: " + e.getMessage());
        }
    }
}
