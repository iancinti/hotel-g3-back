package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.DeleteCustomerRepository;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DeleteCustomerJdbcAdapter implements DeleteCustomerRepository {

    private final Logger log = LoggerFactory.getLogger(DeleteCustomerJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String SOFT_DELETE_CUSTOMER_SQL = "UPDATE Customer SET deleted_at = ? WHERE id_customer = ?";
    private static final String SOFT_DELETE_PERSONAL_DATA_SQL = "UPDATE Personal_data SET deleted_at = ? WHERE id_personal_data = (SELECT id_personal_data FROM Customer WHERE id_customer = ?)";

    public DeleteCustomerJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Integer idCustomer) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        try {
            int rowsAffectedCustomer = jdbcTemplate.update(
                    SOFT_DELETE_CUSTOMER_SQL,
                    currentTimestamp,
                    idCustomer
            );

            if (rowsAffectedCustomer > 0) {
                log.info("Cliente marcado como eliminado (soft delete) en Customer: ID={}", idCustomer);

                int rowsAffectedPersonalData = jdbcTemplate.update(
                        SOFT_DELETE_PERSONAL_DATA_SQL,
                        currentTimestamp,
                        idCustomer
                );

                if (rowsAffectedPersonalData > 0) {
                    log.info("Personal_data marcado como eliminado (soft delete): ID del Cliente={}", idCustomer);
                } else {
                    log.info("No se encontró Personal_data para el Cliente con ID: {}", idCustomer);
                }
            } else {
                log.info("No se encontró cliente con ID: {}", idCustomer);
            }
        } catch (DataAccessException e) {
            log.error("Error al marcar cliente como eliminado: {}", e.getMessage());
            throw new GenericException("Error al acceder a la base de datos al eliminar el cliente", e);
        }
    }
}



