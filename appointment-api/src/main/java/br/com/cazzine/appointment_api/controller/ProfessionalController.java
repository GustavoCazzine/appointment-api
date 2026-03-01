package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.ProfessionalRequestDTO;
import br.com.cazzine.appointment_api.dto.ProfessionalResponseDTO;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    @Autowired
    ProfessionalService professionalService;

    @PostMapping
    public ProfessionalResponseDTO createProfessional(@RequestBody  ProfessionalRequestDTO newProfessional){
        Professional infNewProfessional = professionalService.createProfessional(newProfessional);

        return new ProfessionalResponseDTO(
            infNewProfessional.getId(),
            infNewProfessional.getName(),
            infNewProfessional.getEmail(),
            infNewProfessional.getCompany().getName()
        );
    }

    @GetMapping
    public List<ProfessionalResponseDTO> getAllProfessionals(){
        List<Professional> professionals = professionalService.getAllProfessional();
        return professionals.stream()
                .map(professional ->new ProfessionalResponseDTO(
                        professional.getId(),
                        professional.getName(),
                        professional.getEmail(),
                        professional.getCompany().getName()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ProfessionalResponseDTO findById(@PathVariable Integer id){
        Professional professional = professionalService.findById(id);
        return new ProfessionalResponseDTO(
                professional.getId(),
                professional.getName(),
                professional.getEmail(),
                professional.getCompany().getName()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        professionalService.deleteById(id);
    }
}
