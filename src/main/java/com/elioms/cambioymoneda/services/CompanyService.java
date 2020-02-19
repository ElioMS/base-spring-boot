package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company save(Company company);
}
