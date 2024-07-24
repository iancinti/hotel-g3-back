package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.in.UpdateCustomerCommand;
import com.g3.hotel_g3_back.customer.application.port.out.UpdateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCase implements UpdateCustomerCommand {

    private final UpdateCustomerRepository updateCustomerRepository;

    public UpdateCustomerUseCase(UpdateCustomerRepository updateCustomerRepository) {
        this.updateCustomerRepository = updateCustomerRepository;
    }

    @Override
    public void execute(Integer idCustomer, Customer customer) {
        updateCustomerRepository.execute(idCustomer, customer);
    }
}

