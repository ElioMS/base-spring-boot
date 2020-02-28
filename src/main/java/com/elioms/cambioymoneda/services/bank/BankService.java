package com.elioms.cambioymoneda.services.bank;

import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.BankAccount;

import java.util.List;

public interface BankService {

    List<BankDto> findAll();
    List<BankAccount> findPublicBankAccounts(Long id);
    BankDto save(Bank bank);
    BankDto findById(Long id);

}
