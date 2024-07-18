package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.DeleteCustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteCustomerJdbcAdapter implements DeleteCustomerRepository {

    @Override
    public void execute(String id) {
        System.out.println("Cliente eliminado (soft delete): ID=" + id);
    }
}

