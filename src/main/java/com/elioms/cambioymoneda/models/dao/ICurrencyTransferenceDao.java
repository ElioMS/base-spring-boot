package com.elioms.cambioymoneda.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.elioms.cambioymoneda.models.entity.CurrencyTransference;

public interface ICurrencyTransferenceDao extends CrudRepository<CurrencyTransference, Long>{

    long deleteByTransferenceId(Long id);

}
