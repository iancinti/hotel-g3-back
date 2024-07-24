package com.g3.hotel_g3_back.service.application.usecase;


import com.g3.hotel_g3_back.service.appliction.port.out.CreateServiceRepository;
import com.g3.hotel_g3_back.service.appliction.usecase.CreateServiceUseCase;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateServiceUseCaseTest {

    @Mock
    private CreateServiceRepository createServiceRepository;

    @InjectMocks
    private CreateServiceUseCase createServiceUseCase;

    @Test
    void execute_shouldCallCreateServiceRepository() {
        Service service = new Service();  // Supone que Service tiene un constructor adecuado o se inicializa de alguna manera.

        createServiceUseCase.execute(service);

        verify(createServiceRepository, times(1)).execute(service);
    }
}
