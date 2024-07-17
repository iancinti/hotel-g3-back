package com.g3.hotel_g3_back.customer.adapter.in;

import com.g3.hotel_g3_back.customer.application.port.in.RetriveCustomerQuery;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(CustomerControllerAdapter.class);
    private final RetriveCustomerQuery retriveCustomerQuery;

    public CustomerControllerAdapter(RetriveCustomerQuery retriveCustomerQuery) {
        this.retriveCustomerQuery = retriveCustomerQuery;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers() {
        log.info("Se recibió una solicitud para obtener los clientes");
        List<Customer> response = retriveCustomerQuery.execute();
        log.info("Respondiendo con los clientes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
