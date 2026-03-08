package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.AppointmentRequestDTO;
import br.com.cazzine.appointment_api.exceptions.AppointmentNotFoundException;
import br.com.cazzine.appointment_api.exceptions.DoubleBookingException;
import br.com.cazzine.appointment_api.model.Appointment;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    CompanyService companyService;
    @Autowired
    ProfessionalService professionalService;
    @Autowired
    ServiceItemService serviceItemService;
    public Appointment createAppointment(AppointmentRequestDTO newAppointment){
        Company company = companyService.findById(newAppointment.getCompanyId());
        Professional professional = professionalService.findById(newAppointment.getProfessionalId());
        ServiceItem service = serviceItemService.findById(newAppointment.getServiceItemId());

        boolean isOcupied = appointmentRepository.existsByProfessionalIdAndAppointmentDate(newAppointment.getProfessionalId(), newAppointment.getAppointmentDate());

        if(isOcupied){
            throw new DoubleBookingException("Este profissional já possui um agendamento neste horário exato.");
        }

        return appointmentRepository.save(new Appointment(
                newAppointment.getCustomerName(),
                newAppointment.getAppointmentDate(),
                company,
                professional,
                service
        ));
    }

    public Appointment appointmentByID(Integer id){
        return appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado"));
    }

    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }
}
