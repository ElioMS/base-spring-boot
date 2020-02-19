package com.elioms.cambioymoneda.services.currency;

import com.elioms.cambioymoneda.models.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> findAll();
    Currency save(Currency currency);
    Currency findById(Long id);

}
