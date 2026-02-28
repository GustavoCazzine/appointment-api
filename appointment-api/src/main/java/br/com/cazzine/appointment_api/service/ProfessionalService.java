package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.ProfessionalRequestDTO;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {
    @Autowired
    ProfessionalRepository professionalRepository;
    @Autowired
    CompanyService companyService;

    public Professional createProfessional(ProfessionalRequestDTO newProfessional){
        Company findCompany = companyService.findById(newProfessional.getCompanyId());
        Professional infoProfessional = new Professional(newProfessional.getName(), newProfessional.getEmail(), findCompany);

        return professionalRepository.save(infoProfessional);
    }
}
