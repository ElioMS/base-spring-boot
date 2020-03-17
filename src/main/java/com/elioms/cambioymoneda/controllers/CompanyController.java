package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.dto.BeneficiaryDto;
import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> index() {
        return companyService.findAll();
    }

    @GetMapping("/{id}/beneficiaries")
    public List<BeneficiaryDto> findBeneficiaries(@PathVariable Long id) {
        return companyService.findBeneficiaries(id);
    }

    @GetMapping("/{id}/bank/{bankId}")
    public List<BankAccount> findBankAccounts(@PathVariable Long id, @PathVariable Long bankId) {
        return companyService.findBankAccounts(id, bankId);
    }

    @GetMapping("/{id}/bankAccounts")
    public List<BankAccount> findCompanyBankAccounts(@PathVariable Long id) {
        return companyService.listBankAccounts(id);
    }

    @PostMapping
    public Company createCompany(@Valid @RequestBody Company company, Errors errors) {
        InvalidRequest.check(errors);

        var newErrors = new BindException(this, "");

        if (companyService.existsByRuc(company.getRuc())) {
            newErrors.addError(new FieldError("", "ruc", "El RUC ya ha sido tomado."));
        }

        if (companyService.existsByEmail(company.getEmail())) {
            newErrors.addError(new FieldError("", "email", "El email ya ha sido tomado."));
        }

        InvalidRequest.check(newErrors);

        return companyService.save(company);
    }
}
