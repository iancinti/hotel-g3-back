package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.out.UpdateCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UpdateCustomerUseCaseTest {

    @Mock
    private UpdateCustomerRepository updateCustomerRepository;

    @InjectMocks
    private UpdateCustomerUseCase updateCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallUpdateCustomerRepository() {
        Integer idCustomer = 1;
        Customer customer = new Customer(idCustomer, 2, "John", "Doe", "john.doe@example.com", "1234567890");

        doNothing().when(updateCustomerRepository).execute(idCustomer, customer);

        updateCustomerUseCase.execute(idCustomer, customer);

        verify(updateCustomerRepository, times(1)).execute(idCustomer, customer);
    }
}

