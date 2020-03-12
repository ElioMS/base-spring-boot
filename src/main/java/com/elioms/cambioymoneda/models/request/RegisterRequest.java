package com.elioms.cambioymoneda.models.request;

import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.entity.Country;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RegisterRequest {

    private Long companyId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
    private Integer documentType;

    @NotEmpty
    private String documentNumber;

    @NotEmpty
    private String birthDate;

    private Country country;

    private String password;

    private String confirmPassword;

    @Valid
    @NotEmpty(message = "Listado de cuentas bancarias no puede estar vacío")
    @NotNull
    private List<@Valid BankAccount> bankAccounts;
}
