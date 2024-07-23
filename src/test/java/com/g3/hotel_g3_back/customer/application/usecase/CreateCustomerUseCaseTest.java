package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.out.CreateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CreateCustomerUseCaseTest {

    @Mock
    private CreateCustomerRepository createCustomerRepository;

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallCreateCustomerRepository() {
        Customer customer = new Customer(1, 1, "John", "Doe", "john.doe@example.com", "123456789");
        doNothing().when(createCustomerRepository).execute(customer);

        createCustomerUseCase.execute(customer);

        verify(createCustomerRepository, times(1)).execute(customer);
    }
}

