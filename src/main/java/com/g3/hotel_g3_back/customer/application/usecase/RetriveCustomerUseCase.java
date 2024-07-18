package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.in.RetriveCustomerQuery;
import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriveCustomerUseCase implements RetriveCustomerQuery {

    private final RetriveCustomerRepository retriveCustomerRepository;

    public RetriveCustomerUseCase(RetriveCustomerRepository retriveCustomerRepository) {
        this.retriveCustomerRepository = retriveCustomerRepository;
    }

    @Override
    public List<Customer> execute() {
        return retriveCustomerRepository.execute();
    }
}
