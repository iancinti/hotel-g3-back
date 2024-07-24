package com.g3.hotel_g3_back.customer.application.usecase;

import com.g3.hotel_g3_back.customer.application.port.out.DeleteCustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteCustomerUseCaseTest {

    @Mock
    private DeleteCustomerRepository deleteCustomerRepository;

    @InjectMocks
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_shouldCallDeleteCustomerRepository() {
        Integer idCustomer = 1;
        doNothing().when(deleteCustomerRepository).execute(idCustomer);

        deleteCustomerUseCase.execute(idCustomer);

        verify(deleteCustomerRepository, times(1)).execute(idCustomer);
    }
}

