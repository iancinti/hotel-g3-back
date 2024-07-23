package com.g3.hotel_g3_back.service.application.usecase;

import com.g3.hotel_g3_back.service.appliction.port.out.DeleteServiceRepository;
import com.g3.hotel_g3_back.service.appliction.usecase.DeleteServiceUseCase;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteServiceUseCaseTest {

    @Mock
    private DeleteServiceRepository deleteServiceRepository;

    @InjectMocks
    private DeleteServiceUseCase deleteServiceUseCase;

    @Test
    void execute_shouldCallDeleteServiceRepository() {
        Integer serviceId = 1;
        Service service = new Service();  // Supone que Service tiene un constructor adecuado o se inicializa de alguna manera.

        deleteServiceUseCase.execute(serviceId, service);

        verify(deleteServiceRepository, times(1)).execute(serviceId, service);
    }
}
