package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.in.RetriveCustomerByIdQuery;
import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerByIdRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class RetriveCustomerByIdUseCase implements RetriveCustomerByIdQuery {

    private final RetriveCustomerByIdRepository retriveCustomerByIdRepository;

    public RetriveCustomerByIdUseCase(RetriveCustomerByIdRepository retriveCustomerByIdRepository) {
        this.retriveCustomerByIdRepository = retriveCustomerByIdRepository;
    }

    @Override
    public Customer execute(Integer idCustomer) {
        return retriveCustomerByIdRepository.execute(idCustomer);
    }
}
