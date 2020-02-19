package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private IBankAccountDao bankAccountDao;

    @Override
    public List<BankAccount> paginate(int page, int size, String sortDir, String sort) {
        PageRequest pageReq
                = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<BankAccount> accounts = bankAccountDao.findAll(pageReq);

        return accounts.getContent();
    }

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return bankAccountDao.save(bankAccount);
    }

    @Override
    public BankAccount update(BankAccount bankAccount, Long id) {

        BankAccount account = bankAccountDao.findById(id).orElseThrow(
            () -> new NotFoundException("La cuenta de banco no existe")
        );

        account.setIdentifier(bankAccount.getIdentifier());
        account.setBankAccountNumber(bankAccount.getBankAccountNumber());
        account.setInterbankAccountNumber(bankAccount.getInterbankAccountNumber());
        account.setBank(bankAccount.getBank());
        account.setCurrency(bankAccount.getCurrency());
//        account.setCompany(bankAccount.getCompany());

        return bankAccountDao.save(account);
    }
}
