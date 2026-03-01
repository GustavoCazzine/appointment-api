package br.com.cazzine.appointment_api.dto;


import java.time.LocalDateTime;

public class AppointmentResponseDTO {
    private Integer id;
    private String customerName;
    private LocalDateTime appointmentDate;
    private String companyName;
    private String professionalName;
    private String serviceItemName;

    public AppointmentResponseDTO(Integer id, String customerName, LocalDateTime appointmentDate, String companyName, String professionalName, String serviceItemName) {
        this.id = id;
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.companyName = companyName;
        this.professionalName = professionalName;
        this.serviceItemName = serviceItemName;
    }

    public AppointmentResponseDTO() {
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getServiceItemName() {
        return serviceItemName;
    }

    public void setServiceItemName(String serviceItemName) {
        this.serviceItemName = serviceItemName;
    }
}
