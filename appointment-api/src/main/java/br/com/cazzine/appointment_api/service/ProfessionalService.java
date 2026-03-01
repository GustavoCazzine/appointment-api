package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.ProfessionalRequestDTO;
import br.com.cazzine.appointment_api.exceptions.ProfessionalNotFoundException;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {
    @Autowired
    ProfessionalRepository professionalRepository;
    @Autowired
    CompanyService companyService;

    public Professional createProfessional(ProfessionalRequestDTO newProfessional){
        Company findCompany = companyService.findById(newProfessional.getCompanyId());
        return professionalRepository.save(new Professional(newProfessional.getName(), newProfessional.getEmail(), findCompany));
    }

    public Professional findById(Integer id){
        return professionalRepository.findById(id).orElseThrow(() -> new ProfessionalNotFoundException("Profissional não encontrado"));
    }

    public List<Professional> getAllProfessional(){
        return professionalRepository.findAll();
    }

    public void deleteById(Integer id){
        professionalRepository.deleteById(id);
    }
}
