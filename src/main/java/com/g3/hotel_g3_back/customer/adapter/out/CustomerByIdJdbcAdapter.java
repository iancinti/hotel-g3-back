package com.g3.hotel_g3_back.customer.adapter.out;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerByIdRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerByIdJdbcAdapter implements RetriveCustomerByIdRepository {

    @Override
    public Customer execute(String id) {
        if ("1".equals(id)) {
            return new Customer(1, "Juan Perez");
        } else if ("2".equals(id)) {
            return new Customer(2, "Maria Gomez");
        }
        return null;
    }
}
