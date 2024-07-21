package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.RetrieveAttractionQuery;
import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveAttractionUseCase implements RetrieveAttractionQuery {

    private final RetrieveAttractionRepository retrieveAttractionRepository;

    public RetrieveAttractionUseCase(RetrieveAttractionRepository retrieveAttractionRepository) {
        this.retrieveAttractionRepository = retrieveAttractionRepository;
    }

    @Override
    public List<Attraction> execute() {
        return retrieveAttractionRepository.execute();
    }
}
