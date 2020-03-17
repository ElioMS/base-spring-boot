package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.BeneficiaryTransferDetail;
import org.springframework.data.repository.CrudRepository;

public interface IBeneficiaryTransferDetailDao extends CrudRepository<BeneficiaryTransferDetail, Long> {

    long deleteByTransferenceId(Long id);

}
