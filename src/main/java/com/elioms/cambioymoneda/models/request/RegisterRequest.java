package com.elioms.cambioymoneda.models.request;

import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Company;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RegisterRequest {

    @Valid
    @NotNull
    private Company company;

    @Valid
    @NotEmpty(message = "Listado de bancos no puede estar vacío")
    @NotNull
    private List<@Valid BankAccount> bankAccounts;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
