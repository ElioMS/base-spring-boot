package com.elioms.cambioymoneda.services.beneficiary;

import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;

import java.util.List;

public interface BeneficiaryService {

    List<Beneficiary> findAll();
    Beneficiary create(BeneficiaryRequest request);
    List<BankAccount> listBankAccountByBeneficiary(Long id);
}
