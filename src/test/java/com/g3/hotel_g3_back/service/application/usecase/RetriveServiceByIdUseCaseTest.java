package com.g3.hotel_g3_back.service.application.usecase;

import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceByIdQueryRepository;
import com.g3.hotel_g3_back.service.appliction.usecase.RetriveServiceByIdUseCase;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RetriveServiceByIdUseCaseTest {

    @Mock
    private RetiveServiceByIdQueryRepository retiveServiceByIdQueryRepository;

    @InjectMocks
    private RetriveServiceByIdUseCase retriveServiceByIdUseCase;

    @Test
    void execute_shouldReturnServiceForValidId() {
        Integer serviceId = 1;
        Service expectedService = new Service();  // Assume Service has an appropriate constructor or initializer.
        when(retiveServiceByIdQueryRepository.execute(serviceId)).thenReturn(expectedService);

        Service result = retriveServiceByIdUseCase.execute(serviceId);

        assertNotNull(result, "The returned service should not be null");
        assertEquals(expectedService, result, "The service retrieved should match the expected service");
        verify(retiveServiceByIdQueryRepository, times(1)).execute(serviceId);
    }

    @Test
    void execute_shouldReturnNullForInvalidId() {
        Integer invalidServiceId = -1;
        when(retiveServiceByIdQueryRepository.execute(invalidServiceId)).thenReturn(null);

        Service result = retriveServiceByIdUseCase.execute(invalidServiceId);

        assertNull(result, "No service should be retrieved for an invalid ID");
        verify(retiveServiceByIdQueryRepository, times(1)).execute(invalidServiceId);
    }
}
