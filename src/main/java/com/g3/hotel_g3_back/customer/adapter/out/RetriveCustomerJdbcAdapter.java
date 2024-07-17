package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RetriveCustomerJdbcAdapter implements RetriveCustomerRepository {

    @Override
    public List<Customer> execute() {
        return List.of(new Customer(1, "Ian Cinti"),
                new Customer(2, "Cinti Ian"));
    }
}
