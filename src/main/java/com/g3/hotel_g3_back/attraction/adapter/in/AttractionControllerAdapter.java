package com.g3.hotel_g3_back.attraction.adapter.in;

import com.g3.hotel_g3_back.attraction.application.port.in.*;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);

    private final RetrieveAttractionQuery retrieveAttractionQuery;
    private final RetrieveAttractionByIdQuery retrieveAttractionByIdQuery;
    private final UpdateAttractionCommand updateAttractionCommand;
    private final CreateAttractionCommand createAttractionCommand;
    private final DeleteAttractionCommand deleteAttractionCommand;

    public AttractionControllerAdapter(RetrieveAttractionQuery retrieveAttractionQuery,
                                       RetrieveAttractionByIdQuery retrieveAttractionByIdQuery,
                                       UpdateAttractionCommand updateAttractionCommand,
                                       CreateAttractionCommand createAttractionCommand,
                                       DeleteAttractionCommand deleteAttractionCommand){
        this.retrieveAttractionQuery = retrieveAttractionQuery;
        this.retrieveAttractionByIdQuery = retrieveAttractionByIdQuery;
        this.updateAttractionCommand = updateAttractionCommand;
        this.createAttractionCommand = createAttractionCommand;
        this.deleteAttractionCommand = deleteAttractionCommand;
    }

    @GetMapping()
    public ResponseEntity<List<Attraction>> getAttractions() {
        log.info("Se recibió una solicitud para obtener las atracciones");
        List<Attraction> response = retrieveAttractionQuery.execute();
        log.info("Respondiendo con las atracciones");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getAttractionById(@PathVariable String id) {
        log.info("Se recibió una solicitud para obtener la atraccion con ID: " + id);
        Attraction response = retrieveAttractionByIdQuery.execute(id);
        log.info("Respondiendo con la atraccion");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Void> createAttraction(@RequestBody Attraction attraction) {
        log.info("Se recibió una solicitud para crear una nueva atraccion");
        createAttractionCommand.execute(attraction);
        log.info("Atraccion creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAttraction(@PathVariable String id, @RequestBody Attraction attraction) {
        log.info("Se recibió una solicitud para actualizar la atraccion con ID: " + id);
        updateAttractionCommand.execute(id, attraction);
        log.info("Reserva actualizada exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> softDeleteAttraction(@PathVariable String id) {
        log.info("Se recibió una solicitud para eliminar lógicamente la atraccion con ID: " + id);
        deleteAttractionCommand.execute(id);
        log.info("Atraccion eliminada lógicamente exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}