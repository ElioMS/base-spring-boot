package com.elioms.cambioymoneda.services.company;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.dao.IBeneficiaryDao;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.dao.CompanyRepository;
import com.elioms.cambioymoneda.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IBeneficiaryDao iBeneficiaryDao;

    @Autowired
    private IBankAccountDao iBankAccountDao;

    @Override
    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public List<Beneficiary> findBeneficiaries(Long id) {
        companyRepository.findById(id).orElseThrow(
            () -> new NotFoundException("La compañía no ha sido encontrada")
        );
        return iBeneficiaryDao.findByCompanyId(id);
    }

    @Override
    public List<BankAccount> findBankAccounts(Long id, Long bankId) {
        return iBankAccountDao.findByCompanyIdAndBankId(id, bankId);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
