package com.g3.hotel_g3_back.service.appliction.usecase;

import com.g3.hotel_g3_back.service.appliction.port.in.RetriveServiceQuery;
import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceQueryRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriveServiceUseCase implements RetriveServiceQuery {

    private final RetiveServiceQueryRepository retiveServiceQueryRepository;

    public RetriveServiceUseCase(RetiveServiceQueryRepository retiveServiceQueryRepository){
        this.retiveServiceQueryRepository =retiveServiceQueryRepository;
    }

    @Override
    public List<Service> execute() {
        return  retiveServiceQueryRepository.execute();
    }
}
