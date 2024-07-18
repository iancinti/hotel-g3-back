package com.g3.hotel_g3_back.service.appliction.usecase;

import com.g3.hotel_g3_back.service.appliction.port.in.DeleteServiceCommand;
import com.g3.hotel_g3_back.service.appliction.port.out.DeleteServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Component;

@Component
public class DeleteServiceUseCase implements DeleteServiceCommand {

    private final DeleteServiceRepository deleteServiceRepository;

    public DeleteServiceUseCase(DeleteServiceRepository deleteServiceRepository) {
        this.deleteServiceRepository=deleteServiceRepository;
    }

    @Override
    public void execute(String id, Service service) {
        deleteServiceRepository.execute(id,service);
    }



}
