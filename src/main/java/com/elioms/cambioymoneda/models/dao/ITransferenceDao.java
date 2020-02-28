package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.entity.Transference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransferenceDao extends JpaRepository<Transference, Long> {

    @Query("SELECT t FROM Transference t WHERE t.company.id IN (:companyList)")
    Page<Transference> findByCompanyList(List<Long> companyList, Pageable req);

    @Query("SELECT t FROM Transference t WHERE t.company.id IN (:companyList)")
    List<Transference> findByCompanyLastTen(List<Long> companyList, Pageable req);
}
