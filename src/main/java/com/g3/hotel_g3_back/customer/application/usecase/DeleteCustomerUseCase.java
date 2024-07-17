package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.in.DeleteCustomerCommand;
import com.g3.hotel_g3_back.customer.application.port.out.DeleteCustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase implements DeleteCustomerCommand {

    private final DeleteCustomerRepository deleteCustomerRepository;

    public DeleteCustomerUseCase(DeleteCustomerRepository deleteCustomerRepository) {
        this.deleteCustomerRepository = deleteCustomerRepository;
    }

    @Override
    public void execute(String id) {
        deleteCustomerRepository.execute(id);
    }
}

