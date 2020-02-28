package com.elioms.cambioymoneda.models.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.elioms.cambioymoneda.models.entity.*;
import lombok.Data;

@Data
public class CreateTransferRequest implements Serializable  {

	@NotNull
    private Integer type;

    @NotNull
    private Float totalAmount;

    @NotNull
    private List<BeneficiaryTransferDetail> beneficiaries;
    
    @NotNull
    @Valid
    private List<@Valid CurrencyTransference> currencyValues;
    
    @NotNull
    private BankAccount bankAccount;

    @NotNull
    private Company company;

}
