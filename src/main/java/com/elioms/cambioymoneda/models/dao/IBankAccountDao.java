package com.elioms.cambioymoneda.models.dao;


import com.elioms.cambioymoneda.models.entity.BankAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBankAccountDao extends PagingAndSortingRepository<BankAccount, Long> {
}
