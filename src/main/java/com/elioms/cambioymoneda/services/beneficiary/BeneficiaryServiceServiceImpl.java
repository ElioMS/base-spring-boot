package com.elioms.cambioymoneda.services.beneficiary;

import com.elioms.cambioymoneda.models.dao.IBankAccountDao;
import com.elioms.cambioymoneda.models.dao.IBeneficiaryDao;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.dto.BeneficiaryListDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Service
public class BeneficiaryServiceServiceImpl implements BeneficiaryService {

    @Autowired
    private IBeneficiaryDao iBeneficiaryDao;

    @Autowired
    private IBankAccountDao iBankAccountDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Beneficiary> findAll() {
        return iBeneficiaryDao.findAll();
    }

    @Override
    public List<Beneficiary> findByCompanyAndType(Long companyId, Integer type) {
        return iBeneficiaryDao.findByCompanyIdAndType(companyId, type);
    }

    @Override
    public List<BankAccount> findBankAccounts(List<Long> beneficiariesId) {
        return iBankAccountDao.findByBeneficiaryIdIsIn(beneficiariesId);
//        List<BankAccount> accounts = iBankAccountDao.findByBeneficiaryIdIsIn(beneficiariesId);

//        return accounts.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
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

    @Override
    public Beneficiary findBeneficiaryByRuc(String ruc) {
        return iBeneficiaryDao.findByDocumentNumber(ruc).orElse(null);
    }

    private void createBankAccounts(Beneficiary beneficiary, List<BankAccount> bankAccountList) {
        bankAccountList.forEach(bankAccount -> {
            bankAccount.setBeneficiary(beneficiary);
            iBankAccountDao.save(bankAccount);
        });
    }

    private BeneficiaryListDto convertToDto(BankAccount bankAccount) {
        return modelMapper.map(bankAccount, BeneficiaryListDto.class);
    }
}
