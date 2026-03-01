package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.ServiceItemRequestDTO;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-items")
public class ServiceItemController {
    @Autowired
    ServiceItemService serviceItemService;

    @PostMapping
    public ServiceItem createServiceItem(@RequestBody ServiceItemRequestDTO newServiceItem){
        return serviceItemService.createServiceItem(newServiceItem);
    }
}
