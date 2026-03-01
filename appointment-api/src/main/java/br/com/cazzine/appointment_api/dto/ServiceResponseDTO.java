package br.com.cazzine.appointment_api.dto;


import java.math.BigDecimal;

public class ServiceResponseDTO {
    private Integer id;
    private String description;
    private BigDecimal price;
    private Integer durationInMinutes;
    private String companyName;

    public ServiceResponseDTO(Integer id, String description, BigDecimal price, Integer durationInMinutes, String companyName) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.companyName = companyName;
    }

    public ServiceResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
