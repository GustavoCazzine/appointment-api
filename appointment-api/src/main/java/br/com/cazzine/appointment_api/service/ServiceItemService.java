package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.ServiceItemRequestDTO;
import br.com.cazzine.appointment_api.exceptions.ServiceNotFoundException;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItemService {
    @Autowired
    ServiceItemRepository serviceRepository;
    @Autowired
    CompanyService companyService;

    public ServiceItem createServiceItem(ServiceItemRequestDTO newServiceItem){
        Company findyIdCompany = companyService.findById(newServiceItem.getCompanyId());
        return serviceRepository.save(new ServiceItem(newServiceItem.getDescription(), newServiceItem.getPrice(), newServiceItem.getDurationInMinutes(),findyIdCompany));
    }

    public void deleterById(Integer id){
        serviceRepository.deleteById(id);
    }

    public List<ServiceItem> getAllService(){
        return serviceRepository.findAll();
    }

    public ServiceItem findById(Integer id){
         return serviceRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException("Serviço não encontrado."));
    }
}
