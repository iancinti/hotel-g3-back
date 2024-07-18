package com.g3.hotel_g3_back.service.adapter.out;

;
import com.g3.hotel_g3_back.service.appliction.port.out.CreateServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Repository;

@Repository
public class CreateServiceJdbcAdapter implements CreateServiceRepository {
    @Override
    public void execute(Service service){
        System.out.println("Servicio creado: " + service);
    }
}
