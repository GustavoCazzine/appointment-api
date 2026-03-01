package br.com.cazzine.appointment_api.dto;


public class CompanyResponseDTO {
    private Integer id;
    private String name;
    private String cnpj;
    private String phone;

    public CompanyResponseDTO() {
    }

    public CompanyResponseDTO(Integer id, String name, String cnpj, String phone) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
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
