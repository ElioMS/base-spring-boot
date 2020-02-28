package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface IBankDao extends CrudRepository<Bank, Long> {

}
