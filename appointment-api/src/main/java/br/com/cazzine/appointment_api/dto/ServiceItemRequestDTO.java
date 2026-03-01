package br.com.cazzine.appointment_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ServiceItemRequestDTO {

    @NotBlank(message = "A DESCRIÇÃO não pode estar em branco.")
    private String description;

    @NotNull(message = "O PREÇO não pode ser vázio.")
    private BigDecimal price;

    @NotNull(message = "A DURAÇÃO não pode ser vázio.")
    private Integer durationInMinutes;

    @NotNull(message = "O ID da empresa não pode ser vázio.")
    private Integer companyId;

    public ServiceItemRequestDTO() {
    }

    public ServiceItemRequestDTO(String description, BigDecimal price, Integer durationInMinutes, Integer companyId) {
        this.description = description;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
