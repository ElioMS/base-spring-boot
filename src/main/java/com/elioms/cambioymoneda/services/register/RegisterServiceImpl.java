package com.elioms.cambioymoneda.services.register;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.CompanyRepository;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.request.RegisterRequest;
import com.elioms.cambioymoneda.services.BankAccountService;
import com.elioms.cambioymoneda.services.company.CompanyService;
import com.elioms.cambioymoneda.services.currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CurrencyService currencyService;

    public String register(RegisterRequest body) {

        Company newCompany = companyRepository.findById(body.getCompanyId()).orElseThrow(
            () -> new NotFoundException("La compañia no ha sido encontrada")
        );


        createBankAccounts(body.getBankAccounts(), newCompany);

        return "OK";
    }


//    private Company createCompany(Company company) {
//        return companyService.save(company);
//    }

    private void createBankAccounts(List<BankAccount> bankAccounts, Company company) {
        bankAccounts.forEach(bankAccount -> {
            bankAccount.setCompany(company);
            bankAccountService.save(bankAccount);
        });
    }

}
