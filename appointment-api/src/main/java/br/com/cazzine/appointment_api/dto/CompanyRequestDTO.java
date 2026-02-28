package br.com.cazzine.appointment_api.dto;

import jakarta.validation.constraints.NotBlank;

public class CompanyRequestDTO {

    @NotBlank(message = "O NOME não pode estar em branco.")
    private String name;
    @NotBlank(message = "O CNPJ não pode estar em branco")
    private String cnpj;
    @NotBlank(message = "O TELEFONE não pode estar em branco")
    private String phone;

    public CompanyRequestDTO() {
    }

    public CompanyRequestDTO(String name, String phone, String cnpj) {
        this.name = name;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
