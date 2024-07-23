package com.g3.hotel_g3_back.customer.adapter.in;

import com.g3.hotel_g3_back.customer.application.port.in.*;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerControllerAdapterTest {

    @Mock
    private RetriveCustomerQuery retriveCustomerQuery;

    @Mock
    private RetriveCustomerByIdQuery retriveCustomerByIdQuery;

    @Mock
    private CreateCustomerCommand createCustomerCommand;

    @Mock
    private UpdateCustomerCommand updateCustomerCommand;

    @Mock
    private DeleteCustomerCommand deleteCustomerCommand;

    @InjectMocks
    private CustomerControllerAdapter customerControllerAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCustomers_shouldReturnListOfCustomers() {
        List<Customer> customers = Collections.singletonList(new Customer(1, 1, "John", "Doe", "john.doe@example.com", "123456789"));
        when(retriveCustomerQuery.execute()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerControllerAdapter.getCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
        verify(retriveCustomerQuery, times(1)).execute();
    }

    @Test
    void getCustomerById_shouldReturnCustomer() {
        Customer customer = new Customer(1, 1, "John", "Doe", "john.doe@example.com", "123456789");
        when(retriveCustomerByIdQuery.execute(1)).thenReturn(customer);

        ResponseEntity<Customer> response = customerControllerAdapter.getCustomerById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(retriveCustomerByIdQuery, times(1)).execute(1);
    }

    @Test
    void createCustomer_shouldReturnCreatedStatus() {
        Customer customer = new Customer(1, 1, "John", "Doe", "john.doe@example.com", "123456789");
        doNothing().when(createCustomerCommand).execute(customer);

        ResponseEntity<Void> response = customerControllerAdapter.createCustomer(customer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(createCustomerCommand, times(1)).execute(customer);
    }

    @Test
    void updateCustomer_shouldReturnNoContentStatus() {
        Customer customer = new Customer(1, 1, "John", "Doe", "john.doe@example.com", "123456789");
        doNothing().when(updateCustomerCommand).execute(1, customer);

        ResponseEntity<Void> response = customerControllerAdapter.updateCustomer(1, customer);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(updateCustomerCommand, times(1)).execute(1, customer);
    }

    @Test
    void deleteCustomer_shouldReturnNoContentStatus() {
        doNothing().when(deleteCustomerCommand).execute(1);

        ResponseEntity<Void> response = customerControllerAdapter.deleteCustomer(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleteCustomerCommand, times(1)).execute(1);
    }
}

