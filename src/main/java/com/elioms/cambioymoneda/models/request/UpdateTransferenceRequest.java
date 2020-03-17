package com.elioms.cambioymoneda.models.request;

import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.BeneficiaryTransferDetail;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.entity.CurrencyTransference;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class UpdateTransferenceRequest implements Serializable {

    private Integer type;

    private Float totalAmount;

    @NotNull
    private String status;

    @NotNull
    private Integer step;

    private List<BeneficiaryTransferDetail> beneficiaries;

    private List<@Valid CurrencyTransference> currencyValues;

    private BankAccount bankAccount;

    private Company company;

}