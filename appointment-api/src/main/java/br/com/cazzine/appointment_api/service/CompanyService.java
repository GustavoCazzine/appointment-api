package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.CompanyRequestDTO;
import br.com.cazzine.appointment_api.exceptions.CompanyNotFoundException;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company createCompany(CompanyRequestDTO newCompany){
        return companyRepository.save(new Company(newCompany.getName(), newCompany.getCnpj(), newCompany.getPhone()));
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Integer id){
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada."));
    }

    public void deleteCompany(Integer id){
        companyRepository.deleteById(id);
    }
}
