package com.elioms.cambioymoneda.services.bank;

import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.BankAccount;

import java.util.List;

public interface BankService {

    List<Bank> findAll();
    List<BankAccount> findPublicBankAccounts(Long id);
    Bank save(Bank bank);
    Bank findById(Long id);

}
