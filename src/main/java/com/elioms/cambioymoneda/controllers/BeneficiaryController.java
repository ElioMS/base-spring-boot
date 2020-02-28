package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;
import com.elioms.cambioymoneda.services.beneficiary.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping
    public List<Beneficiary> index() {
        return beneficiaryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiary create(@Valid @RequestBody BeneficiaryRequest body, Errors errors) {
        InvalidRequest.check(errors);

        return beneficiaryService.create(body);
    }

    @GetMapping("/{id}/accounts")
    public List<BankAccount> listBankAccounts(@PathVariable Long id) {
        return beneficiaryService.listBankAccountByBeneficiary(id);
    }
}
