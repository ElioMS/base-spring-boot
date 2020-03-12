package com.elioms.cambioymoneda.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo nombre es requerido")
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String surname;

    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty
    @Column
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name= "first_cellphone", nullable = false)
    private String firstCellphone;

    @Column(name= "second_cellphone")
    private String secondCellphone;

    private Boolean status = false;

    @Column(name = "document_type")
    private Integer documentType;

    @Column(unique = true, name = "document_number")
    private String documentNumber;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "pre_register_token")
    private String preRegisterToken;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private Integer type;

    @JsonIgnoreProperties({"user"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Company> companies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "privilege_user", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "privilege_id"})})
    private List<Privilege> privileges;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})})
    private List<Role> roles;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "company_id")
    private Integer companyId;

    public User() {
        this.companies = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        enabled = true;
//        type = 1;
        createdAt = new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPreRegisterToken() {
        return preRegisterToken;
    }

    public void setPreRegisterToken(String preRegisterToken) {
        this.preRegisterToken = preRegisterToken;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
