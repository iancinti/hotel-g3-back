package com.g3.hotel_g3_back.service.appliction.port.out;

import com.g3.hotel_g3_back.service.domain.Service;

import java.util.List;

public interface RetiveServiceQueryRepository {
    List<Service> execute();
}
