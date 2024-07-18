package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.UpdateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateServiceJdbcAdapter implements UpdateServiceRepository {

    @Override
    public void execute(String id, Service service){
        System.out.println("Se actualizo el servicio on ID: " + id + "a" + service);
    }
}
