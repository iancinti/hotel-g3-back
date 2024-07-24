package com.g3.hotel_g3_back.service.appliction.usecase;

import com.g3.hotel_g3_back.service.appliction.port.in.RetriveServiceByIdQuery;
import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceByIdQueryRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Component;

@Component
public class RetriveServiceByIdUseCase implements RetriveServiceByIdQuery {

    private final RetiveServiceByIdQueryRepository retiveServiceByIdQueryRepository;

    public RetriveServiceByIdUseCase(RetiveServiceByIdQueryRepository retiveServiceByIdQueryRepository){
        this.retiveServiceByIdQueryRepository = retiveServiceByIdQueryRepository;
    }

    @Override
    public Service execute (Integer id){
        return retiveServiceByIdQueryRepository.execute(id);
    }


}
