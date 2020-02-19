package com.elioms.cambioymoneda.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String ruc;

    @NotNull
    @Column(nullable = false)
    private Integer type;

    @NotNull
    @NotEmpty
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @NotNull
    @NotEmpty
    @Column(name = "public_name", nullable = false)
    private String publicName;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String address;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String email;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String web;

    @NotNull
    @NotEmpty
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String annexed;

    @NotNull
    @NotEmpty
    @Column(name= "first_cellphone", nullable = false)
    private String firstCellphone;

    @Column(name= "second_cellphone")
    private String secondCellphone;

    @Column(name= "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @JsonIgnoreProperties({"companies", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAnnexed() {
        return annexed;
    }

    public void setAnnexed(String annexed) {
        this.annexed = annexed;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
}
