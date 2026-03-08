package br.com.cazzine.appointment_api.controller;


import br.com.cazzine.appointment_api.dto.AppointmentRequestDTO;
import br.com.cazzine.appointment_api.dto.AppointmentResponseDTO;
import br.com.cazzine.appointment_api.model.Appointment;
import br.com.cazzine.appointment_api.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponseDTO createAppointment(@Valid @RequestBody AppointmentRequestDTO newAppointment){
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

    @GetMapping
    public List<AppointmentResponseDTO> getAllAppoitment(){
        List<Appointment> getAll = appointmentService.getAllAppointment();

        return getAll.stream()
                .map(appointment -> new AppointmentResponseDTO(
                        appointment.getId(),
                        appointment.getCustomerName(),
                        appointment.getAppointmentDate(),
                        appointment.getCompany().getName(),
                        appointment.getProfessional().getName(),
                        appointment.getServiceItem().getDescription()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public AppointmentResponseDTO findById(@PathVariable  Integer id){
        Appointment appointment = appointmentService.appointmentByID(id);
        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getCustomerName(),
                appointment.getAppointmentDate(),
                appointment.getCompany().getName(),
                appointment.getProfessional().getName(),
                appointment.getServiceItem().getDescription()
        );
    }
}
