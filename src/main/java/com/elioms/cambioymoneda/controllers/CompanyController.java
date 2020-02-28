package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.entity.BankAccount;
import com.elioms.cambioymoneda.models.entity.Beneficiary;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Beneficiary> findBeneficiaries(@PathVariable Long id) {
        return companyService.findBeneficiaries(id);
    }

    @GetMapping("/{id}/bank/{bankId}")
    public List<BankAccount> findBankAccounts(@PathVariable Long id, @PathVariable Long bankId) {
        return companyService.findBankAccounts(id, bankId);
    }
}
