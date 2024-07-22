package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.DeleteCustomerRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DeleteCustomerJdbcAdapter implements DeleteCustomerRepository {

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
                System.out.println("Cliente marcado como eliminado (soft delete) en Customer: ID=" + idCustomer);

                int rowsAffectedPersonalData = jdbcTemplate.update(
                        SOFT_DELETE_PERSONAL_DATA_SQL,
                        currentTimestamp,
                        idCustomer
                );

                if (rowsAffectedPersonalData > 0) {
                    System.out.println("Personal_data marcado como eliminado (soft delete): ID del Cliente=" + idCustomer);
                } else {
                    System.out.println("No se encontró Personal_data para el Cliente con ID: " + idCustomer);
                }
            } else {
                System.out.println("No se encontró cliente con ID: " + idCustomer);
            }
        } catch (DataAccessException e) {
            System.out.println("Error al marcar cliente como eliminado: " + e.getMessage());
        }
    }
}


