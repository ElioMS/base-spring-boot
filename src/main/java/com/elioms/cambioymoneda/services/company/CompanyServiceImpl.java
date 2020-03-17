package com.elioms.cambioymoneda.services.company;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.dao.IBeneficiaryDao;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.dto.BeneficiaryDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.dao.CompanyRepository;
import com.elioms.cambioymoneda.services.company.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IBeneficiaryDao iBeneficiaryDao;

    @Autowired
    private IBankAccountDao iBankAccountDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public List<BeneficiaryDto> findBeneficiaries(Long id) {
        companyRepository.findById(id).orElseThrow(
            () -> new NotFoundException("La compañía no ha sido encontrada")
        );

        var items = iBeneficiaryDao.findByCompanyId(id);

        return items.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> findBankAccounts(Long id, Long bankId) {
        return iBankAccountDao.findByCompanyIdAndBankId(id, bankId);
    }

    @Override
    public List<BankAccount> listBankAccounts(Long id) {
        return iBankAccountDao.findByCompanyId(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Boolean existsByRuc(String ruc) {
        return companyRepository.existsByRuc(ruc);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return companyRepository.existsByEmail(email);
    }

    private BeneficiaryDto convertToDto(Beneficiary beneficiary) {
        return modelMapper.map(beneficiary, BeneficiaryDto.class);
    }
}
