package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerByIdRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RetriveCustomerByIdJdbcAdapter implements RetriveCustomerByIdRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_CUSTOMER_BY_ID_SQL = "SELECT id_customer, id_personal_data FROM Customer WHERE id_customer = ?";

    public RetriveCustomerByIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer execute(Integer id_customer) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_BY_ID_SQL, new Object[]{id_customer}, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontró cliente con ID: " + id_customer);
            return null; // Retorna null si no se encuentra el cliente
        }
    }

    private static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer idCustomer = rs.getInt("id_customer");
            Integer idPersonalData = rs.getInt("id_personal_data");
            return new Customer(idCustomer, idPersonalData);
        }
    }
}

