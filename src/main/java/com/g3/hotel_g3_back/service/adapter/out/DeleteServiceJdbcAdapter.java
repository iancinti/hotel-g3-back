package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.DeleteServiceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteServiceJdbcAdapter implements DeleteServiceRepository {
    @Override
    public void execute(String id) {
        System.out.println("El servicio con " +id + " fue eliminado");
    }
}
