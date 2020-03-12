package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.dao.IBankDao;
import com.elioms.cambioymoneda.models.dao.ICurrencyDao;
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

    private IBankDao bankDao;
    private ICurrencyDao currencyDao;

    public BankAccountServiceImpl(IBankDao iBankDao,
                                  ICurrencyDao iCurrencyDao) {
        this.bankDao = iBankDao;
        this.currencyDao = iCurrencyDao;
    }

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

    @Override
    public String generateIdentifier(Long bankId, Long currencyId) {

        var bank = bankDao.findById(bankId).orElse(null);
        var currency = currencyDao.findById(currencyId).orElse(null);
        var lastBankAccount = bankAccountDao.findTopByOrderByIdDesc();

        return bank.getShortName()+currency.getShortName()+lastBankAccount.getId();
    }
}
