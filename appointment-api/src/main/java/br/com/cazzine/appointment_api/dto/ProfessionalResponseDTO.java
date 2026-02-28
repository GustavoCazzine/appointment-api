package br.com.cazzine.appointment_api.dto;

import br.com.cazzine.appointment_api.model.Company;

public class ProfessionalResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String companyName;

    public ProfessionalResponseDTO() {
    }

    public ProfessionalResponseDTO(Integer id, String name, String email, String companyName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
