package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivilegeDao extends CrudRepository<Privilege, Long> {
}
