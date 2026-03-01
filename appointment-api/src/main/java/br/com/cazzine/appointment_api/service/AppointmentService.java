package br.com.cazzine.appointment_api.service;

import br.com.cazzine.appointment_api.dto.AppointmentRequestDTO;
import br.com.cazzine.appointment_api.model.Appointment;
import br.com.cazzine.appointment_api.model.Company;
import br.com.cazzine.appointment_api.model.Professional;
import br.com.cazzine.appointment_api.model.ServiceItem;
import br.com.cazzine.appointment_api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return appointmentRepository.save(new Appointment(
                newAppointment.getCustomerName(),
                newAppointment.getAppointmentDate(),
                company,
                professional,
                service
        ));
    }
}
