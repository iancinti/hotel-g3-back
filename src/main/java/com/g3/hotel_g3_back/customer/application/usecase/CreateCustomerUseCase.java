package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.in.CreateCustomerCommand;
import com.g3.hotel_g3_back.customer.application.port.out.CreateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerUseCase implements CreateCustomerCommand {

    private final CreateCustomerRepository createCustomerRepository;

    public CreateCustomerUseCase(CreateCustomerRepository createCustomerRepository) {
        this.createCustomerRepository = createCustomerRepository;
    }

    @Override
    public void execute(Customer customer) {
        createCustomerRepository.execute(customer);
    }
}
