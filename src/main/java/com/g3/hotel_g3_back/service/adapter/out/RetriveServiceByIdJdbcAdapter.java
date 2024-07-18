package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceByIdQueryRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Repository;

@Repository
public class RetriveServiceByIdJdbcAdapter implements RetiveServiceByIdQueryRepository {

    @Override
    public Service execute(String id ) {
        return new Service ("1","Estacionamiento","Gratuito 24hs");
    }
}
