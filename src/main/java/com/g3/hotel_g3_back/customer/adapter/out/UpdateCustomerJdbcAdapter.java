package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.UpdateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateCustomerJdbcAdapter implements UpdateCustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String UPDATE_CUSTOMER_SQL = "UPDATE customers SET name = ? WHERE id = ?";

    public UpdateCustomerJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(String id, Customer customer) {
        try {
            jdbcTemplate.update(
                    UPDATE_CUSTOMER_SQL,
                    customer.getName(),
                    id
            );
            System.out.println("Cliente actualizado: ID=" + id + ", Nombre=" + customer.getName());
        } catch (DataAccessException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }
}

