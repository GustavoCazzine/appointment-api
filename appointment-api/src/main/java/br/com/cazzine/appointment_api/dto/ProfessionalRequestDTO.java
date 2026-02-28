package br.com.cazzine.appointment_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProfessionalRequestDTO {
    @NotBlank(message = "O NOME do profissional não pode estar em branco")
    private String name;

    @NotBlank(message = "O EMAIL do profissional não pode estar em branco")
    private String email;

    @NotNull(message = "O ID da empresa do profissional não pode estar em branco")
    private Integer companyId;

    public ProfessionalRequestDTO() {
    }

    public ProfessionalRequestDTO(String name, String email, Integer companyId) {
        this.name = name;
        this.email = email;
        this.companyId = companyId;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
