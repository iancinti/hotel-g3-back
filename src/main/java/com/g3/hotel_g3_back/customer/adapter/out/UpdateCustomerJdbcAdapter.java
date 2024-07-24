package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.UpdateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Component
public class UpdateCustomerJdbcAdapter implements UpdateCustomerRepository {

    private final Logger log = LoggerFactory.getLogger(UpdateCustomerJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

    private static final String UPDATE_CUSTOMER_SQL = "UPDATE Customer SET id_personal_data = ? WHERE id_customer = ?";
    private static final String UPDATE_PERSONAL_DATA_SQL = "UPDATE Personal_data SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE id_personal_data = ?";

    public UpdateCustomerJdbcAdapter(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = new DataSourceTransactionManager(dataSource);
    }

    @Override
    public void execute(Integer idCustomer, Customer customer) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            jdbcTemplate.update(
                    UPDATE_CUSTOMER_SQL,
                    customer.getIdPersonalData(),
                    idCustomer
            );

            jdbcTemplate.update(
                    UPDATE_PERSONAL_DATA_SQL,
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getPhoneNumber(),
                    customer.getIdPersonalData()
            );

            transactionManager.commit(status);
            log.info("Cliente y datos personales actualizados exitosamente: ID Cliente={}", idCustomer);
        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            log.error("Error al actualizar cliente: {}", e.getMessage());
            throw new GenericException("Error inesperado al actualizar el cliente", e);
        }
    }
}


