package com.elioms.cambioymoneda.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer type;

    @NotEmpty(message = "El campo nombre es requerido")
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column
    private String contactInfo;

    @Column
    private String annexed;

    @Column(name = "document_type")
    private Integer documentType;

    @Column(unique = true, name = "document_number")
    private String documentNumber;

    @NotEmpty
    @Column(nullable = false)
    private String address;

    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @NotEmpty
    @Column(name= "first_cellphone", nullable = false)
    private String firstCellphone;

    @Column(name= "second_cellphone")
    private String secondCellphone;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Boolean status = false;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAnnexed() {
        return annexed;
    }

    public void setAnnexed(String annexed) {
        this.annexed = annexed;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
