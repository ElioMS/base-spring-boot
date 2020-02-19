package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface ICurrencyDao extends CrudRepository<Currency, Long> {
}
