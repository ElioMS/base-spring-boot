package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBeneficiaryDao extends JpaRepository<Beneficiary, Long> {

    List<Beneficiary> findByCompanyId(Long id);

}
