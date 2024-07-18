package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.UpdateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateCustomerJdbcAdapter implements UpdateCustomerRepository {

    @Override
    public void execute(String id, Customer customer) {
        System.out.println("Cliente actualizado: ID=" + id + ", Nombre=" + customer.getName());
    }
}

