package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.dao.IFavoriteCurrencyTypeDao;
import com.elioms.cambioymoneda.models.dao.IUserDao;
import com.elioms.cambioymoneda.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/me")
public class AuthController {

    @Autowired
    private IUserDao iUserDao;
    private IFavoriteCurrencyTypeDao iFavoriteCurrencyTypeDao;

    public AuthController(IFavoriteCurrencyTypeDao iFavoriteCurrencyTypeDao) {
        this.iFavoriteCurrencyTypeDao = iFavoriteCurrencyTypeDao;
    }

    @GetMapping
    public User currentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication().getName();
        return iUserDao.findByEmail(auth);
    }

}
