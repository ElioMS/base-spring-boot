package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<BankDto> index() {
        return bankService.findAll();
    }

    @GetMapping("/{id}")
    public BankDto show(@PathVariable Long id) {
        return bankService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankDto store(@Valid @RequestBody Bank bank, Errors errors) {
        InvalidRequest.check(errors);

        return bankService.save(bank);
    }

}
