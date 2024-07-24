package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.CreateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class CreateCustomerJdbcAdapter implements CreateCustomerRepository {

    private final Logger log = LoggerFactory.getLogger(CreateCustomerJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_PERSONAL_DATA_SQL = "INSERT INTO Personal_data (id_personal_data, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO Customer (id_customer, id_personal_data) VALUES (?, ?)";

    public CreateCustomerJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Customer customer) {
        try {
            Integer personalDataId = customer.getIdPersonalData();

            if (personalDataId == null) {
                throw new RuntimeException("El id_personal_data no puede ser nulo.");
            }

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(
                        INSERT_PERSONAL_DATA_SQL
                );
                ps.setInt(1, personalDataId);
                ps.setString(2, customer.getFirstName());
                ps.setString(3, customer.getLastName());
                ps.setString(4, customer.getEmail());
                ps.setString(5, customer.getPhoneNumber());
                return ps;
            });

            jdbcTemplate.update(
                    INSERT_CUSTOMER_SQL,
                    customer.getIdCustomer(),
                    personalDataId
            );

            log.info("Cliente creado exitosamente con ID Personal_data={}", personalDataId);
        } catch (DataAccessException e) {
            log.error("Error al crear cliente: {}", e.getMessage());
            throw new GenericException("Error al acceder a la base de datos al crear el cliente", e);
        } catch (RuntimeException e) {
            log.error("Error inesperado: {}", e.getMessage());
            throw new GenericException("Error inesperado al crear el cliente", e);
        }
    }
}

