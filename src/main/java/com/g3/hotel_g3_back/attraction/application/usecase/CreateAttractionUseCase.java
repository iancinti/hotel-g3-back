package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.CreateAttractionCommand;
import com.g3.hotel_g3_back.attraction.application.port.out.CreateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;

public class CreateAttractionUseCase implements CreateAttractionCommand {

    private final CreateAttractionRepository createAttractionRepository;

    public CreateAttractionUseCase(CreateAttractionRepository createAttractionRepository){
        this.createAttractionRepository = createAttractionRepository;
    }

    @Override
    public void execute(Attraction attraction) {
        createAttractionRepository.execute(attraction);
    }
}
