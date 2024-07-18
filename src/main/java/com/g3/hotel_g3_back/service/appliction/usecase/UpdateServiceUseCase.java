package com.g3.hotel_g3_back.service.appliction.usecase;

import com.g3.hotel_g3_back.service.appliction.port.in.UpdateServiceCommand;
import com.g3.hotel_g3_back.service.appliction.port.out.UpdateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Component;

@Component
public class UpdateServiceUseCase implements UpdateServiceCommand {

    private final UpdateServiceRepository updateServiceRepository;

    public UpdateServiceUseCase(UpdateServiceRepository updateServiceRepository) {
        this.updateServiceRepository = updateServiceRepository;
    }

    @Override
    public void execute(String id, Service service) {
        updateServiceRepository.execute(id, service);
    }
}
