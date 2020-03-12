package com.elioms.cambioymoneda.models.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePasswordRequest {

    @NotNull
    private Long id;

    @NotEmpty
    @Size(min = 6, max = 24)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
