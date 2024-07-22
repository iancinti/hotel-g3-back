package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetriveCustomerUseCaseTest {

    @Mock
    private RetriveCustomerRepository retriveCustomerRepository;

    @InjectMocks
    private RetriveCustomerUseCase retriveCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnListOfCustomers() {
        Customer customer = new Customer(1, 2, "John", "Doe", "john.doe@example.com", "1234567890");
        List<Customer> expectedCustomers = Collections.singletonList(customer);
        when(retriveCustomerRepository.execute()).thenReturn(expectedCustomers);

        List<Customer> result = retriveCustomerUseCase.execute();

        assertEquals(expectedCustomers, result);
        verify(retriveCustomerRepository, times(1)).execute();
    }
}
