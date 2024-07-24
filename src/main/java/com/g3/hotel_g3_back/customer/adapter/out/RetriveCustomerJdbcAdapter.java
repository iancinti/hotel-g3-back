package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class RetriveCustomerJdbcAdapter implements RetriveCustomerRepository {

    private final Logger log = LoggerFactory.getLogger(RetriveCustomerJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT c.id_customer, c.id_personal_data, pd.first_name, pd.last_name, pd.email, pd.phone_number " +
            "FROM Customer c " +
            "JOIN Personal_Data pd ON c.id_personal_data = pd.id_personal_data";

    public RetriveCustomerJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> execute() {
        try {
            return jdbcTemplate.query(SELECT_ALL_CUSTOMERS_SQL, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException e) {
            log.warn("No se encontraron clientes.");
            return List.of();
        } catch (Exception e) {
            log.error("Error al recuperar clientes.", e);
            throw new GenericException("Error inesperado al recuperar clientes", e);
        }
    }

    private static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer idCustomer = rs.getInt("id_customer");
            Integer idPersonalData = rs.getInt("id_personal_data");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phone_number");

            return new Customer(idCustomer, idPersonalData, firstName, lastName, email, phoneNumber);
        }
    }
}



