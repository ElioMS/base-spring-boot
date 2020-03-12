package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryDao extends CrudRepository<Country, Long> {
}
