package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.services.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> index() {
        return bankService.findAll();
    }

    @GetMapping("/{id}/publicAccounts")
    public List<BankAccount> findPublicAccounts(@PathVariable Long id) {
        return bankService.findPublicBankAccounts(id);
    }

    @GetMapping("/{id}")
    public Bank show(@PathVariable Long id) {
        return bankService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank store(@Valid @RequestBody Bank bank, Errors errors) {
        InvalidRequest.check(errors);

        return bankService.save(bank);
    }

}
