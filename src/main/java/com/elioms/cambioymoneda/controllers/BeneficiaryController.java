package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.request.BeneficiaryRequest;
import com.elioms.cambioymoneda.models.response.MessageBodyResponse;
import com.elioms.cambioymoneda.services.beneficiary.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping
    public ResponseEntity<?> index(@RequestParam(required=false) Long companyId, @RequestParam(required=false) Integer type) {

        if (companyId != null && type != null) {
            var beneficiaries = beneficiaryService.findByCompanyAndType(companyId, type);
            System.out.println("ID's: "+beneficiaries.toString());

            List<Long> ids = beneficiaries.stream()
                        .map(Beneficiary::getId)
                        .collect(Collectors.toList());

            System.out.println("ID's: "+ids);

            return ResponseEntity.ok(beneficiaryService.findBankAccounts(ids));
        }

        return ResponseEntity.ok(beneficiaryService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiary create(@Valid @RequestBody BeneficiaryRequest body, Errors errors) {
        InvalidRequest.check(errors);

        return beneficiaryService.create(body);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody List<BankAccount> body, @PathVariable Long id) {
//
//    }

    @PostMapping("/verifyByRuc")
    public ResponseEntity<?> findByRuc(@RequestBody Map<String, String> body) {
        var ruc = body.get("ruc");

        var newErrors = new BindException(this, "");

        if (ruc == null || ruc.equals("")) {
            newErrors.addError(new FieldError("", "email", "El RUC es obligatorio"));
        }

        InvalidRequest.check(newErrors);

        MessageBodyResponse response = new MessageBodyResponse();
        response.setData(beneficiaryService.findBeneficiaryByRuc(ruc));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/accounts")
    public List<BankAccount> listBankAccounts(@PathVariable Long id) {
        return beneficiaryService.listBankAccountByBeneficiary(id);
    }
}
