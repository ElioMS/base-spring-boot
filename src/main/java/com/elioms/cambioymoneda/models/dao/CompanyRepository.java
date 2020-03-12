package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Company;
import org.springframework.data.repository.CrudRepository;


public interface CompanyRepository extends CrudRepository<Company, Long> {

    Boolean existsByRuc(String ruc);
    Boolean existsByEmail(String email);
}
