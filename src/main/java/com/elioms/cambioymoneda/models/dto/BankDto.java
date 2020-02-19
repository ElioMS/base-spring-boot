package com.elioms.cambioymoneda.models.dto;

import java.io.Serializable;

public class BankDto implements Serializable {

    private Long id;
    private String name;
    private String shortName;
    private String swift;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getShortName() {
//        return shortName;
//    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getFullName() {
        return this.shortName+" - "+this.name;
    }

//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
}
