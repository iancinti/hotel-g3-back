package com.g3.hotel_g3_back.service.appliction.usecase;

import com.g3.hotel_g3_back.service.appliction.port.in.CreateServiceCommand;
import com.g3.hotel_g3_back.service.appliction.port.out.CreateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Component;

@Component
public class CreateServiceUseCase implements CreateServiceCommand {
    private final CreateServiceRepository createServiceRepository;

    public CreateServiceUseCase(CreateServiceRepository createServiceRepository){
        this.createServiceRepository = createServiceRepository;
    }
    @Override
    public void execute(Service service) {
        createServiceRepository.execute(service);
    }

}
