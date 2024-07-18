package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.CreateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CreateCustomerJdbcAdapter implements CreateCustomerRepository {

    @Override
    public void execute(Customer customer) {
        System.out.println("Cliente creado: " + customer.getName());
    }
}
