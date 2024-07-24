package com.g3.hotel_g3_back.service.appliction.port.in;

import com.g3.hotel_g3_back.service.domain.Service;

public interface CreateServiceCommand {
   void execute (Service service);
}
