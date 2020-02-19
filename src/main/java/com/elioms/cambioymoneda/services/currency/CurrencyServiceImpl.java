package com.elioms.cambioymoneda.services.currency;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.ICurrencyDao;
import com.elioms.cambioymoneda.models.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private ICurrencyDao iCurrencyDao;

    @Override
    public List<Currency> findAll() {
        return (List<Currency>) iCurrencyDao.findAll();
    }

    @Override
    public Currency save(Currency currency) {
        return iCurrencyDao.save(currency);
    }

    @Override
    public Currency findById(Long id) {
        return iCurrencyDao.findById(id).orElseThrow(
                () -> new NotFoundException("Tipo de moneda no encontrado")
        );
    }
}
