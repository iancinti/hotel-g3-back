package com.g3.hotel_g3_back.customer.application.port.out;

import com.g3.hotel_g3_back.customer.domain.Customer;

public interface RetriveCustomerByIdRepository {
    Customer execute(Integer idCustomer);
}
