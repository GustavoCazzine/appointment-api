package br.com.cazzine.appointment_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentRequestDTO {
    @NotBlank(message = "O NOME não pode estar em branco.")
    private String customerName;
    @NotNull(message = "A DATA não pode estar em branco.")
    private LocalDateTime appointmentDate;
    @NotNull(message = "O ID da empresa não pode estar em branco.")
    private Integer companyId;
    @NotNull(message = "O ID do profissional não pode estar em branco.")
    private Integer professionalId;
    @NotNull(message = "O ID do serviço não pode estar em branco.")
    private Integer serviceItemId;

    public AppointmentRequestDTO() {
    }

    public AppointmentRequestDTO(String customerName, LocalDateTime appointmentDate, Integer companyId, Integer professionalId, Integer serviceItemId) {
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.companyId = companyId;
        this.professionalId = professionalId;
        this.serviceItemId = serviceItemId;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Integer serviceItemId) {
        this.serviceItemId = serviceItemId;
    }
}
