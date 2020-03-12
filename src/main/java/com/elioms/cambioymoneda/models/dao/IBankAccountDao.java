package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.BankAccount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IBankAccountDao extends PagingAndSortingRepository<BankAccount, Long> {

    List<BankAccount> findByBeneficiaryId(Long id);

    @Query("SELECT c FROM BankAccount c WHERE c.bank.id =:id AND c.isPrivate = FALSE")
    List<BankAccount> findPublicAccounts(Long id);

    List<BankAccount> findByBeneficiaryIdIsIn(List<Long> ids);

    List<BankAccount> findByCompanyIdAndBankId(Long id, Long bankId);

}
