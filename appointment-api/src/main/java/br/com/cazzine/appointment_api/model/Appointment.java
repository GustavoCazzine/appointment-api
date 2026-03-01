package br.com.cazzine.appointment_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;
    private LocalDateTime appointmentDate;

    @ManyToOne
    private Company company;
    @ManyToOne
    private Professional professional;
    @ManyToOne
    private ServiceItem serviceItem;

    public Appointment() {
    }

    public Appointment(String customerName, LocalDateTime appointmentDate, Company company, Professional professional, ServiceItem serviceItem) {
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.company = company;
        this.professional = professional;
        this.serviceItem = serviceItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public ServiceItem getServiceItem() {
        return serviceItem;
    }

    public void setServiceItem(ServiceItem serviceItem) {
        this.serviceItem = serviceItem;
    }
}


