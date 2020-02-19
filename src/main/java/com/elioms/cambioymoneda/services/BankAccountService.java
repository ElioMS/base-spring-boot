package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> paginate(int page, int size, String sortDir, String sort);
    BankAccount save(BankAccount bankAccount);
    BankAccount update(BankAccount bankAccount, Long id);
}
