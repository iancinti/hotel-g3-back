package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;

import java.util.List;

public class RetrieveAttractionUseCase implements RetrieveAttractionRepository {

    private final RetrieveAttractionRepository retrieveAttractionRepository;

    public RetrieveAttractionUseCase(RetrieveAttractionRepository retrieveAttractionRepository) {
        this.retrieveAttractionRepository = retrieveAttractionRepository;
    }

    @Override
    public List<Attraction> execute() {
        return retrieveAttractionRepository.execute();
    }
}
