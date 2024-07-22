package com.g3.hotel_g3_back.service.adapter.in;

import com.g3.hotel_g3_back.booking.adapter.in.BookingControllerAdapter;
import com.g3.hotel_g3_back.service.appliction.port.in.*;
import com.g3.hotel_g3_back.service.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/service")
public class ServiceControllerAdapter {
    private final Logger log = LoggerFactory.getLogger(BookingControllerAdapter.class);

    public ServiceControllerAdapter(RetriveServiceQuery retriveServiceQuery, RetriveServiceByIdQuery retriveServiceByIdQuery, CreateServiceCommand createServiceCommand, UpdateServiceCommand updateServiceCommand, DeleteServiceCommand deleteServiceCommand) {
        this.retriveServiceQuery = retriveServiceQuery;
        this.retriveServiceByIdQuery = retriveServiceByIdQuery;
        this.createServiceCommand = createServiceCommand;
        this.updateServiceCommand = updateServiceCommand;
        this.deleteServiceCommand = deleteServiceCommand;
    }

    private final RetriveServiceQuery retriveServiceQuery;
    private final RetriveServiceByIdQuery retriveServiceByIdQuery;
    private final CreateServiceCommand createServiceCommand;
    private final UpdateServiceCommand updateServiceCommand;
    private final DeleteServiceCommand deleteServiceCommand;



    @GetMapping()
    public ResponseEntity<List<Service>> getAllService(){
        log.info("Obteniendo servicio");
        List<Service> response = retriveServiceQuery.execute();
        log.info("Respondiendo el servicio");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Integer id){
        log.info("Solicitud servicio por id");
        Service response = retriveServiceByIdQuery.execute(id);
        log.info("Respondiendo al servicio por id");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public  ResponseEntity<Void> createServiceCommand(@RequestBody Service service){
        log.info("Se recibio una solicitud para crear un nuevo servicio");
        createServiceCommand.execute(service);
        log.info("Se creo un nuevo servicio");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateServiceCommand(@PathVariable String id, @RequestBody Service service){
        log.info("Solicitud para actualizar  servicio " + id);
        updateServiceCommand.execute(id,service);
        log.info("Servicio actualizado");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceCommand(@PathVariable String id, @RequestBody Service service){
        log.info("Solicitud para eliminar un servicio"+ id);
        deleteServiceCommand.execute(id, service);
        log.info("Se eliminio el servicio");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
