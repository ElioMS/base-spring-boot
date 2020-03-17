package com.elioms.cambioymoneda.services.favoriteCurrencyType;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.ICurrencyDao;
import com.elioms.cambioymoneda.models.dao.IFavoriteCurrencyTypeDao;
import com.elioms.cambioymoneda.models.dao.IUserDao;
import com.elioms.cambioymoneda.models.entity.Currency;
import com.elioms.cambioymoneda.models.entity.FavoriteCurrencyType;
import com.elioms.cambioymoneda.models.request.FavoriteCurrencyTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteCurrencyTypeServiceImpl implements FavoriteCurrencyTypeService {

    private IUserDao iUserDao;
    private ICurrencyDao iCurrencyDao;
    private IFavoriteCurrencyTypeDao iFavoriteCurrencyTypeDao;

    public FavoriteCurrencyTypeServiceImpl(ICurrencyDao iCurrencyDao,
                                           IFavoriteCurrencyTypeDao iFavoriteCurrencyTypeDao,
                                           IUserDao iUserDao) {
        this.iCurrencyDao = iCurrencyDao;
        this.iFavoriteCurrencyTypeDao = iFavoriteCurrencyTypeDao;
        this.iUserDao = iUserDao;
    }

    @Override
    public List<FavoriteCurrencyType> findAll() {
        return null;
    }

    @Override
    public List<FavoriteCurrencyType> findByUserId(Long userId) {
        return iFavoriteCurrencyTypeDao.findByUserId(userId);
    }

    @Override
    public FavoriteCurrencyType save(FavoriteCurrencyTypeRequest data) {

        var auth = SecurityContextHolder.getContext().getAuthentication().getName();

        var currentUser = iUserDao.findByEmail(auth);
        var salesCurrency = iCurrencyDao.findById(data.getSalesCurrencyId()).orElseThrow(
            () -> new NotFoundException("El valor de la moneda de venta no existe")
        );
        var purchaseCurrency = iCurrencyDao.findById(data.getPurchaseCurrencyId()).orElseThrow(
            () -> new NotFoundException("El valor de la moneda de compra no existe")
        );

        var newFavorite = new FavoriteCurrencyType();
        newFavorite.setValue(data.getValue());
        newFavorite.setUser(currentUser);
        newFavorite.setPurchaseCurrency(purchaseCurrency);
        newFavorite.setSalesCurrency(salesCurrency);

        return iFavoriteCurrencyTypeDao.save(newFavorite);
    }

    @Override
    public FavoriteCurrencyType update(FavoriteCurrencyTypeRequest data, Long id) {
        FavoriteCurrencyType favorite = iFavoriteCurrencyTypeDao.findById(id).orElseThrow(
                () -> new NotFoundException("El tipo de cambio favorito no existe")
        );

        Currency salesCurrency = iCurrencyDao.findById(data.getSalesCurrencyId()).orElseThrow(
                () -> new NotFoundException("El valor de la moneda de venta no existe")
        );

        Currency purchaseCurrency = iCurrencyDao.findById(data.getPurchaseCurrencyId()).orElseThrow(
                () -> new NotFoundException("El valor de la moneda de venta no existe")
        );

        favorite.setValue(data.getValue());
        favorite.setSalesCurrency(salesCurrency);
        favorite.setPurchaseCurrency(purchaseCurrency);

        return iFavoriteCurrencyTypeDao.save(favorite);
    }

    @Override
    public void deleteById(Long id) {

        iFavoriteCurrencyTypeDao.deleteById(id);
    }
}
