package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBankDao extends CrudRepository<Bank, Long> {
    List<Bank> findByCountryId(Long id);
}
