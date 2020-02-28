package com.elioms.cambioymoneda.services.beneficiary;

import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.dao.IBeneficiaryDao;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryServiceServiceImpl implements BeneficiaryService {

    @Autowired
    private IBeneficiaryDao iBeneficiaryDao;

    @Autowired
    private IBankAccountDao iBankAccountDao;

    @Override
    public List<Beneficiary> findAll() {
        return (List<Beneficiary>) iBeneficiaryDao.findAll();
    }

    @Override
    public Beneficiary create(BeneficiaryRequest request) {

        Beneficiary beneficiary = iBeneficiaryDao.save(request.getBeneficiary());
        createBankAccounts(beneficiary, request.getBankAccountList());
        return beneficiary;
    }

    @Override
    public List<BankAccount> listBankAccountByBeneficiary(Long id) {
        return iBankAccountDao.findByBeneficiaryId(id);
    }

    private void createBankAccounts(Beneficiary beneficiary, List<BankAccount> bankAccountList) {
        bankAccountList.forEach( bankAccount -> {
            bankAccount.setBeneficiary(beneficiary);
            iBankAccountDao.save(bankAccount);
        });
    }
}
