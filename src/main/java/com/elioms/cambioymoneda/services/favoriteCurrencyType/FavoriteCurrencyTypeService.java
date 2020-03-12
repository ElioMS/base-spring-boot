package com.elioms.cambioymoneda.services.favoriteCurrencyType;

import com.elioms.cambioymoneda.models.dao.IFavoriteCurrencyTypeDao;
import com.elioms.cambioymoneda.models.entity.FavoriteCurrencyType;
import com.elioms.cambioymoneda.models.request.FavoriteCurrencyTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface FavoriteCurrencyTypeService {

    List<FavoriteCurrencyType> findAll();
    List<FavoriteCurrencyType> findByUserId(Long userId);
    FavoriteCurrencyType save(FavoriteCurrencyTypeRequest data);
    void deleteById(Long id);
}
