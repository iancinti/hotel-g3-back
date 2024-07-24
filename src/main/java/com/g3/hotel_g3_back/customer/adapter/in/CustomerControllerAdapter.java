package com.g3.hotel_g3_back.customer.adapter.in;

import com.g3.hotel_g3_back.customer.application.port.in.*;
import com.g3.hotel_g3_back.customer.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(CustomerControllerAdapter.class);

    private final RetriveCustomerQuery retriveCustomerQuery;
    private final RetriveCustomerByIdQuery retriveCustomerByIdQuery;
    private final CreateCustomerCommand createCustomerCommand;
    private final UpdateCustomerCommand updateCustomerCommand;
    private final DeleteCustomerCommand deleteCustomerCommand;

    public CustomerControllerAdapter(RetriveCustomerQuery retriveCustomerQuery, RetriveCustomerByIdQuery retriveCustomerByIdQuery,
                                     CreateCustomerCommand createCustomerCommand, UpdateCustomerCommand updateCustomerCommand, DeleteCustomerCommand deleteCustomerCommand) {
        this.retriveCustomerQuery = retriveCustomerQuery;
        this.retriveCustomerByIdQuery = retriveCustomerByIdQuery;
        this.createCustomerCommand = createCustomerCommand;
        this.updateCustomerCommand = updateCustomerCommand;
        this.deleteCustomerCommand = deleteCustomerCommand;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers() {
        log.info("Se recibió una solicitud para obtener los clientes");
        List<Customer> response = retriveCustomerQuery.execute();
        log.info("Respondiendo con los clientes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer idCustomer) {
        log.info("Se recibió una solicitud para obtener el cliente con ID: " + idCustomer);
        Customer response = retriveCustomerByIdQuery.execute(idCustomer);
        log.info("Respondiendo con el cliente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        log.info("Se recibió una solicitud para crear un nuevo cliente");
        createCustomerCommand.execute(customer);
        log.info("Cliente creado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Integer idCustomer, @RequestBody Customer customer) {
        log.info("Se recibió una solicitud para actualizar el cliente con ID: " + idCustomer);
        updateCustomerCommand.execute(idCustomer, customer);
        log.info("Cliente actualizado exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer idCustomer) {
        log.info("Se recibió una solicitud para eliminar el cliente con ID: " + idCustomer);
        deleteCustomerCommand.execute(idCustomer);
        log.info("Cliente eliminado exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
