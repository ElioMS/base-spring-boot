package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;

import java.util.List;

public interface BankService {

    List<BankDto> findAll();
    BankDto save(Bank bank);
    BankDto findById(Long id);

}
