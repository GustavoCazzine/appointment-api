package br.com.cazzine.appointment_api.controller;


import br.com.cazzine.appointment_api.dto.AppointmentRequestDTO;
import br.com.cazzine.appointment_api.dto.AppointmentResponseDTO;
import br.com.cazzine.appointment_api.model.Appointment;
import br.com.cazzine.appointment_api.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponseDTO createAppointment(@RequestBody AppointmentRequestDTO newAppointment){
        Appointment newappointment = appointmentService.createAppointment(newAppointment);
        return new AppointmentResponseDTO(
                newappointment.getId(),
                newappointment.getCustomerName(),
                newappointment.getAppointmentDate(),
                newappointment.getCompany().getName(),
                newappointment.getProfessional().getName(),
                newappointment.getServiceItem().getDescription()
        );
    }
}
