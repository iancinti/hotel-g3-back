package com.g3.hotel_g3_back.customer.application.port.in;

import com.g3.hotel_g3_back.customer.domain.Customer;

public interface RetriveCustomerByIdQuery {
    Customer execute(Integer idCustomer);
}
