package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void delete(Long id);

    Boolean verifyUniqueEmail(String email);

}
