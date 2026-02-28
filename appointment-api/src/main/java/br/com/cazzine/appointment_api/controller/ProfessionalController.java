package br.com.cazzine.appointment_api.controller;

import br.com.cazzine.appointment_api.dto.ProfessionalRequestDTO;
import br.com.cazzine.appointment_api.dto.ProfessionalResponseDTO;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
