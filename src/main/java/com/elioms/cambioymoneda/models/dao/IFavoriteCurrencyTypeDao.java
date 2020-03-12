package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.FavoriteCurrencyType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFavoriteCurrencyTypeDao extends CrudRepository<FavoriteCurrencyType, Long> {

    List<FavoriteCurrencyType> findByUserId(Long userId);

}
