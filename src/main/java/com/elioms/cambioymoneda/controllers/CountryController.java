package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.dao.IBankDao;
import com.elioms.cambioymoneda.models.dao.ICountryDao;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private ICountryDao iCountryDao;
    private IBankDao iBankDao;

    public CountryController(ICountryDao iCountryDao,
                             IBankDao iBankDao) {
        this.iCountryDao = iCountryDao;
        this.iBankDao = iBankDao;
    }

    @GetMapping
    public List<Country> index() {
        return (List<Country>) iCountryDao.findAll();
    }

    @GetMapping("/{id}/banks")
    public List<Bank> banksByCountry(@PathVariable Long id) {
        return iBankDao.findByCountryId(id);
    }
}
