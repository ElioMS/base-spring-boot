package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.Privilege;
import com.elioms.cambioymoneda.models.entity.Transference;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.request.CreateUserRequest;
import com.elioms.cambioymoneda.models.request.UpdateEmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findEmployeesByCompany(Integer id);
    List<Privilege> findPrivileges();
    User findById(Long id);
    User save(User user);
    void delete(Long id);

    User updateEmployee(UpdateEmployeeRequest body, Long id);

    Transference lastTransferenceByUser(Long id);

    Boolean verifyUniqueEmail(String email);
    Boolean verifyUniqueDocumentNumber(String documentNumber);

}
