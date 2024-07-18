package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceQueryRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RetriveServiceJdbcAdapter implements RetiveServiceQueryRepository {

    @Override
    public List<Service> execute(){
        return Arrays.asList(
                new Service("1","Wifi","Tod la estadia"),
                new Service("2","Desayuno","Primer dia de estadia")
        );
    }

}
