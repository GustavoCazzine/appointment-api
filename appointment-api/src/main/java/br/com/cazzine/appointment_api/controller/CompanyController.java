package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.CompanyRequestDTO;
import br.com.cazzine.appointment_api.dto.CompanyResponseDTO;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody @Valid CompanyRequestDTO newCompany){
        return companyService.createCompany(newCompany);
    }

    @GetMapping
    public List<CompanyResponseDTO> findAllCompany(){
        List<Company> companies = companyService.findAll();

        return companies.stream()
                .map(company -> new CompanyResponseDTO(
                        company.getId(),
                        company.getName(),
                        company.getCnpj(),
                        company.getPhone()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public CompanyResponseDTO companyFindById(@PathVariable Integer id){
        Company company = companyService.findById(id);
        return new CompanyResponseDTO(
                company.getId(),
                company.getName(),
                company.getCnpj(),
                company.getPhone()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
    }
}
