package com.elioms.cambioymoneda.models.dao;

import com.elioms.cambioymoneda.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

    User findByEmail(String email);
    Boolean existsUserByEmail(String email);

//    @Query("SELECT u FROM User WHERE u.email=?1")
//    public User findByUserEmail(String email);
}
