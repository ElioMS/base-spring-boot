package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bankaccounts")
public class BankAccountController {

//    public List<BankAccount> index()
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> index() {
        return bankAccountService.paginate(0, 10, "DESC", "id");
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount store(@Valid @RequestBody BankAccount bankAccount, Errors errors) {
        InvalidRequest.check(errors);
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/{id}")
    public BankAccount update(@Valid @RequestBody BankAccount bankAccount, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);
        return bankAccountService.update(bankAccount, id);
    }



}
