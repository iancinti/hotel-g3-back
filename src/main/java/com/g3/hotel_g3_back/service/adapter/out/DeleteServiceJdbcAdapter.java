package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.DeleteServiceRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteServiceJdbcAdapter implements DeleteServiceRepository {
    @Override
    public void execute(String id, Service service) {
        System.out.println("El servicio con ID " + id + " y detalles " + service + " fue eliminado");
    }
}
