package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleDao extends CrudRepository<Role, Long> {
}
