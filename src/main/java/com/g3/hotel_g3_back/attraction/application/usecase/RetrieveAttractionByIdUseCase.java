package com.g3.hotel_g3_back.attraction.application.usecase;

import com.g3.hotel_g3_back.attraction.application.port.in.RetrieveAttractionByIdQuery;
import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionByIdRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.springframework.stereotype.Component;

@Component
public class RetrieveAttractionByIdUseCase implements RetrieveAttractionByIdQuery {

    private final RetrieveAttractionByIdRepository retrieveAttractionByIdRepository;

    public RetrieveAttractionByIdUseCase(RetrieveAttractionByIdRepository retrieveAttractionByIdRepository) {
        this.retrieveAttractionByIdRepository = retrieveAttractionByIdRepository;
    }


    @Override
    public Attraction execute(Integer id) {
        return retrieveAttractionByIdRepository.execute(id);
    }
}
