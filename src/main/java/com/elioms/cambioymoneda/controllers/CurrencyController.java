package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.Currency;
import com.elioms.cambioymoneda.services.currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> index() {
        return currencyService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Currency store(@Valid @RequestBody Currency currency, Errors errors) {
        InvalidRequest.check(errors);

        return currencyService.save(currency);
    }

}
