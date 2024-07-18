package com.g3.hotel_g3_back.service.appliction.port.in;

import com.g3.hotel_g3_back.service.domain.Service;


import java.util.List;

public interface RetriveServiceQuery {
    List<Service> execute();

}
