package com.g3.hotel_g3_back.gallery.adapter.in;

import com.g3.hotel_g3_back.gallery.application.port.in.*;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery")
public class GalleryControllerAdapter {

    private final Logger log = LoggerFactory.getLogger(GalleryControllerAdapter.class);

    private final RetrieveGalleryQuery retrieveGalleryQuery;
    private final RetrieveGalleryByIdQuery retrieveGalleryByIdQuery;
    private final CreateGalleryCommand createGalleryCommand;
    private final UpdateGalleryCommand updateGalleryCommand;
    private final DeleteGalleryCommand deleteGalleryCommand;

    public GalleryControllerAdapter(RetrieveGalleryQuery retrieveGalleryQuery, RetrieveGalleryByIdQuery retrieveGalleryByIdQuery,
                                    CreateGalleryCommand createGalleryCommand, UpdateGalleryCommand updateGalleryCommand,
                                    DeleteGalleryCommand deleteGalleryCommand){
        this.retrieveGalleryQuery = retrieveGalleryQuery;
        this.retrieveGalleryByIdQuery = retrieveGalleryByIdQuery;
        this.createGalleryCommand = createGalleryCommand;
        this.updateGalleryCommand = updateGalleryCommand;
        this.deleteGalleryCommand = deleteGalleryCommand;
    }

    @GetMapping()
    public ResponseEntity<List<Gallery>> getGalleryImages(){
        log.info("Se recibe una solicitud para mostrar la galeria de imágenes");
        List<Gallery> response = retrieveGalleryQuery.execute();
        log.info("Se responde con las imagenes de la galeria");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{idImage}")
    public ResponseEntity<Gallery> getGalleryImageById(@PathVariable Integer idImage){
        log.info("Se recibe una solicitud para mostrar la galeria con ID: " + idImage);
        Gallery response = retrieveGalleryByIdQuery.execute(idImage);
        log.info("Se responde con la galeria");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Void> createGallery(@RequestBody Gallery gallery){
        log.info("Se recibe solicitud para crear una galeria");
        createGalleryCommand.execute(gallery);
        log.info("Galery creada correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{idImage}")
    public ResponseEntity<Void> updateGallery(@PathVariable Integer idImage, @RequestBody Gallery gallery){
        log.info("Se recibe solicitud para actualizar la galeria con ID: " + idImage);
        updateGalleryCommand.execute(idImage, gallery);
        log.info("Galeria actualizada correctamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{idImage}")
    public ResponseEntity<Void> deleteGallery(@PathVariable Integer idImage){
        log.info("Se recibe solicitud para eliminar la galeria con ID: " + idImage);
        deleteGalleryCommand.execute(idImage);
        log.info("Galeria eliminada exitosamente");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
