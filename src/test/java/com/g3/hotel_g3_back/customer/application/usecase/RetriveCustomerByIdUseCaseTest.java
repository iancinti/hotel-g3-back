package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.out.RetriveCustomerByIdRepository;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RetriveCustomerByIdUseCaseTest {

    @Mock
    private RetriveCustomerByIdRepository retriveCustomerByIdRepository;

    @InjectMocks
    private RetriveCustomerByIdUseCase retriveCustomerByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldReturnCustomer() {
        Integer idCustomer = 1;
        Customer expectedCustomer = new Customer(idCustomer, 2, "John", "Doe", "john.doe@example.com", "1234567890");
        when(retriveCustomerByIdRepository.execute(idCustomer)).thenReturn(expectedCustomer);

        Customer result = retriveCustomerByIdUseCase.execute(idCustomer);

        assertEquals(expectedCustomer, result);
        verify(retriveCustomerByIdRepository, times(1)).execute(idCustomer);
    }
}
