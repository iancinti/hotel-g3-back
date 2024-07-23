package com.g3.hotel_g3_back.service.application.usecase;

import com.g3.hotel_g3_back.service.appliction.port.out.UpdateServiceRepository;
import com.g3.hotel_g3_back.service.appliction.usecase.UpdateServiceUseCase;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UpdateServiceUseCaseTest {

    @Mock
    private UpdateServiceRepository updateServiceRepository;

    @InjectMocks
    private UpdateServiceUseCase updateServiceUseCase;

    @Test
    void execute_shouldCallUpdateServiceRepository() {

        String serviceId = "1";
        Service service = new Service();

        updateServiceUseCase.execute(serviceId, service);


        verify(updateServiceRepository, times(1)).execute(serviceId, service);
    }
}
