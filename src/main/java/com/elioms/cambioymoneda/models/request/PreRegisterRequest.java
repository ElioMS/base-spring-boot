package com.elioms.cambioymoneda.models.request;

import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
public class PreRegisterRequest {

    @NotNull
    @NotEmpty
    private String email;

    public PreRegisterRequest() {
        this.email = "ggaaaaaa@mail.com";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
