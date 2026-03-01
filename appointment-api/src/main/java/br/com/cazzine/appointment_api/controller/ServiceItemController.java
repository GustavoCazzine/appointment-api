package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.ServiceItemRequestDTO;
import br.com.cazzine.appointment_api.dto.ServiceResponseDTO;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-items")
public class ServiceItemController {
    @Autowired
    ServiceItemService serviceItemService;

    @PostMapping
    public ServiceItem createServiceItem(@RequestBody ServiceItemRequestDTO newServiceItem){
        return serviceItemService.createServiceItem(newServiceItem);
    }

    @DeleteMapping("/{id}")
    public void deleterById(@PathVariable Integer id){
        serviceItemService.deleterById(id);
    }

    @GetMapping
    public List<ServiceResponseDTO> getAll(){
        List<ServiceItem> services = serviceItemService.getAllService();
        return services.stream()
                .map(service -> new ServiceResponseDTO(
                        service.getId(),
                        service.getDescription(),
                        service.getPrice(),
                        service.getDurationInMinutes(),
                        service.getCompany().getName()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ServiceResponseDTO getById(@PathVariable Integer id){
        ServiceItem service = serviceItemService.findById(id);
        return new ServiceResponseDTO(
                service.getId(),
                service.getDescription(),
                service.getPrice(),
                service.getDurationInMinutes(),
                service.getCompany().getName());
    }
}
