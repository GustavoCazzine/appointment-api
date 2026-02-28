package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.CompanyRequestDTO;
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
    public List<Company> findAllCompany(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company companyFindById(@PathVariable Integer id){
        return companyService.findById(id);
    }
}
