package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.DeleteAttractionCommand;
import com.g3.hotel_g3_back.attraction.application.port.out.DeleteAttractionRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteAttractionUseCase implements DeleteAttractionCommand {

    private final DeleteAttractionRepository deleteAttractionRepository;

    public DeleteAttractionUseCase(DeleteAttractionRepository deleteAttractionRepository){
        this.deleteAttractionRepository = deleteAttractionRepository;
    }

    @Override
    public void execute(Integer id) {
        deleteAttractionRepository.execute(id);
    }
}
