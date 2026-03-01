package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.ServiceItemRequestDTO;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceItemService {
    @Autowired
    ServiceItemRepository serviceRepository;
    @Autowired
    CompanyService companyService;

    public ServiceItem createServiceItem(ServiceItemRequestDTO newServiceItem){
        Company findyIdCompany = companyService.findById(newServiceItem.getCompanyId());
        ServiceItem infoNewService = new ServiceItem(newServiceItem.getDescription(), newServiceItem.getPrice(), newServiceItem.getDurationInMinutes(),findyIdCompany);
        return serviceRepository.save(infoNewService);
    }
}
