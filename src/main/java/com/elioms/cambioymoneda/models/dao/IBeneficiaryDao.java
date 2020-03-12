package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface IBeneficiaryDao extends JpaRepository<Beneficiary, Long> {

    List<Beneficiary> findByCompanyId(Long id);
    List<Beneficiary> findByCompanyIdAndType(Long id, Integer type);
    Optional<Beneficiary> findByDocumentNumber(String ruc);

    Boolean existsBeneficiaryByDocumentNumber(String ruc);
    Boolean existsBeneficiaryByEmail(String email);
}
