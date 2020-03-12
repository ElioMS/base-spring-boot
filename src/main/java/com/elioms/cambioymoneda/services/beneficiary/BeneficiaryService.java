package com.elioms.cambioymoneda.services.beneficiary;

import com.elioms.cambioymoneda.models.dto.BeneficiaryListDto;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface BeneficiaryService {

    List<Beneficiary> findAll();
    List<Beneficiary> findByCompanyAndType(Long companyId, Integer type);
    List<BankAccount> findBankAccounts(List<Long> beneficiariesId);
    Beneficiary create(BeneficiaryRequest request);
    List<BankAccount> listBankAccountByBeneficiary(Long id);
    Beneficiary findBeneficiaryByRuc(String ruc);

    Boolean existsByRuc(String ruc);
    Boolean existsByEmail(String email);
}
