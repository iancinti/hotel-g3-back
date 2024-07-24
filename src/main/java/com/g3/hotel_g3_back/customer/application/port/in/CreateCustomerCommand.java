package com.g3.hotel_g3_back.customer.application.port.in;

import com.g3.hotel_g3_back.customer.domain.Customer;

public interface CreateCustomerCommand {
    void execute(Customer customer);
}

