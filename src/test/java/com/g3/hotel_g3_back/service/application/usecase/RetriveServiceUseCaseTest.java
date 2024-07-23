package com.g3.hotel_g3_back.service.application.usecase;

import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceQueryRepository;
import com.g3.hotel_g3_back.service.appliction.usecase.RetriveServiceUseCase;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RetriveServiceUseCaseTest {

    @Mock
    private RetiveServiceQueryRepository retiveServiceQueryRepository;

    @InjectMocks
    private RetriveServiceUseCase retriveServiceUseCase;

    @Test
    void execute_shouldReturnListOfServices() {
        // Setup
        Service service1 = new Service();  // Assume Service has an appropriate constructor or initializer.
        Service service2 = new Service();
        List<Service> expectedServices = Arrays.asList(service1, service2);
        when(retiveServiceQueryRepository.execute()).thenReturn(expectedServices);

        // Execution
        List<Service> result = retriveServiceUseCase.execute();

        // Verification
        assertNotNull(result, "The returned list of services should not be null");
        assertEquals(expectedServices, result, "The list of services retrieved should match the expected list");
        verify(retiveServiceQueryRepository, times(1)).execute();
    }

    @Test
    void execute_shouldHandleEmptyList() {
        // Setup
        when(retiveServiceQueryRepository.execute()).thenReturn(List.of());

        // Execution
        List<Service> result = retriveServiceUseCase.execute();

        // Verification
        assertNotNull(result, "The returned list should not be null");
        assertTrue(result.isEmpty(), "The list of services should be empty if there are no services available");
        verify(retiveServiceQueryRepository, times(1)).execute();
    }
}
