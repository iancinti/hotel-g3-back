package com.g3.hotel_g3_back.service.adapter.in;

import com.g3.hotel_g3_back.service.appliction.port.in.*;
import com.g3.hotel_g3_back.service.domain.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceControllerAdapterTest {

    @Mock
    private RetriveServiceQuery retriveServiceQuery;

    @Mock
    private RetriveServiceByIdQuery retriveServiceByIdQuery;

    @Mock
    private CreateServiceCommand createServiceCommand;

    @Mock
    private UpdateServiceCommand updateServiceCommand;

    @Mock
    private DeleteServiceCommand deleteServiceCommand;

    @InjectMocks
    private ServiceControllerAdapter serviceController;

    @Test
    public void getAllService_ShouldReturnAllServices() {
        List<Service> expectedServices = Arrays.asList(new Service(), new Service());
        when(retriveServiceQuery.execute()).thenReturn(expectedServices);

        ResponseEntity<List<Service>> response = serviceController.getAllService();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedServices, response.getBody());
        verify(retriveServiceQuery, times(1)).execute();
    }

    @Test
    public void getServiceById_ShouldReturnService() {
        Integer id = 1;
        Service expectedService = new Service();
        when(retriveServiceByIdQuery.execute(id)).thenReturn(expectedService);

        ResponseEntity<Service> response = serviceController.getServiceById(id);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedService, response.getBody());
        verify(retriveServiceByIdQuery, times(1)).execute(id);
    }

    @Test
    public void createServiceCommand_ShouldCreateService() {
        Service newService = new Service();

        ResponseEntity<Void> response = serviceController.createServiceCommand(newService);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(createServiceCommand, times(1)).execute(newService);
    }

    @Test
    public void updateServiceCommand_ShouldUpdateService() {
        String id = "1";
        Service updatedService = new Service();

        ResponseEntity<Void> response = serviceController.updateServiceCommand(id, updatedService);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(updateServiceCommand, times(1)).execute(id, updatedService);
    }

    @Test
    public void deleteServiceCommand_ShouldDeleteService() {
        Integer id = 1;
        Service serviceToDelete = new Service();

        ResponseEntity<Void> response = serviceController.deleteServiceCommand(id, serviceToDelete);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleteServiceCommand, times(1)).execute(id, serviceToDelete);
    }
}
