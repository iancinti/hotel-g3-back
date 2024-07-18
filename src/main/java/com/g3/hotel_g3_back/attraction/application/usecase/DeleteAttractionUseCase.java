package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.DeleteAttractionCommand;
import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;

public class DeleteAttractionUseCase implements DeleteAttractionCommand {

    private final DeleteAttractionRepository deleteAttractionRepository;

    public DeleteAttractionUseCase(DeleteAttractionRepository deleteAttractionRepository){
        this.deleteAttractionRepository = deleteAttractionRepository;
    }

    @Override
    public void execute(String id) {
        deleteAttractionRepository.execute(id);
    }
}
