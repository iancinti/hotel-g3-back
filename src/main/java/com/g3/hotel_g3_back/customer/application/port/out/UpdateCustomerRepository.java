package com.g3.hotel_g3_back.customer.application.port.out;

import com.g3.hotel_g3_back.customer.domain.Customer;

public interface UpdateCustomerRepository {
    void execute(String id, Customer customer);
}
