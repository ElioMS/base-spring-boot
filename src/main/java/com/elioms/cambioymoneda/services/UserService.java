package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
    public void delete(Long id);

}
