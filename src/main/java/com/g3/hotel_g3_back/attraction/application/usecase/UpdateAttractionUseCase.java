package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.UpdateAttractionCommand;
import com.g3.hotel_g3_back.attraction.application.port.out.UpdateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;

public class UpdateAttractionUseCase implements UpdateAttractionCommand {

    private final UpdateAttractionRepository updateAttractionRepository;

    public UpdateAttractionUseCase(UpdateAttractionRepository updateAttractionRepository) {
        this.updateAttractionRepository = updateAttractionRepository;
    }


    @Override
    public void execute(String id, Attraction attraction) {
        updateAttractionRepository.execute(id, attraction);
    }
}
