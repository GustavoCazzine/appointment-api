package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.CompanyRequestDTO;
import br.com.cazzine.appointment_api.exceptions.CompanyNotFoundException;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company createCompany(CompanyRequestDTO newCompany){
        Company addCompany = new Company(newCompany.getName(), newCompany.getCnpj(), newCompany.getPhone());
        return companyRepository.save(addCompany);
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Integer id){
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada."));
    }
}
