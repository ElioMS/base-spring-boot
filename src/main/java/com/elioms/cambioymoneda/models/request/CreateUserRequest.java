package com.elioms.cambioymoneda.models.request;

import com.elioms.cambioymoneda.models.entity.Privilege;
import com.elioms.cambioymoneda.models.entity.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CreateUserRequest implements Serializable {

    @NotEmpty(message = "El campo nombre es requerido")
    private String name;

    @NotEmpty(message = "El campo apellido es requerido")
    private String surname;

    @NotNull(message = "El campo tipo de documeto es requerido")
    private Integer documentType;

    @NotEmpty(message = "El campo número de documento es requerido")
    private String documentNumber;

    @NotEmpty(message = "El campo email es requerido")
    private String email;

    @NotEmpty(message = "El campo celular 1 es requerido")
    private String firstCellphone;

    @NotEmpty(message = "El campo celular 2 es requerido")
    private String secondCellphone;

    @NotEmpty(message = "El campo teléfono es requerido")
    private String phoneNumber;

    @NotNull
    private Boolean status;

    @NotNull
    private Role role;

    @NotEmpty(message = "El campo privilegios es requerido")
    private List<Privilege> privileges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstCellphone() {
        return firstCellphone;
    }

    public void setFirstCellphone(String firstCellphone) {
        this.firstCellphone = firstCellphone;
    }

    public String getSecondCellphone() {
        return secondCellphone;
    }

    public void setSecondCellphone(String secondCellphone) {
        this.secondCellphone = secondCellphone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
