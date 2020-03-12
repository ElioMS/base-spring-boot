package com.elioms.cambioymoneda.services.company;

import com.elioms.cambioymoneda.models.dto.BeneficiaryDto;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    List<BeneficiaryDto> findBeneficiaries(Long id);
    List<BankAccount> findBankAccounts(Long id, Long bankId);
    Company save(Company company);

    Boolean existsByRuc(String ruc);
    Boolean existsByEmail(String email);
}
