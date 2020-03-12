package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IPrivilegeDao;
import com.elioms.cambioymoneda.models.dao.IUserDao;
import com.elioms.cambioymoneda.models.entity.Privilege;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.request.CreateUserRequest;
import com.elioms.cambioymoneda.models.request.UpdateEmployeeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPrivilegeDao iPrivilegeDao;

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findById(Long id) throws NotFoundException {
        return userDao.findById(id).orElseThrow(
            () -> new NotFoundException("Usuario no encontrado.")
        );
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User updateEmployee(UpdateEmployeeRequest request, Long id) {
        var employee = userDao.findById(id).orElseThrow(
                () -> new NotFoundException("El empleado no ha sido encontrado")
        );

//        employee.setName(request.getName());
//        employee.setSurname(request.getSurname());
//        employee.setDocumentType(request.getDocumentType());
//        employee.setDocumentNumber(request.getDocumentNumber());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setFirstCellphone(request.getFirstCellphone());
        employee.setSecondCellphone(request.getSecondCellphone());
//        employee.setRoles(Arrays.asList(request.getRole()));
        employee.setPrivileges(request.getPrivileges());
        employee.setEnabled(request.getStatus());

        return userDao.save(employee);
    }

    @Override
    public Boolean verifyUniqueEmail(String email) {
        return userDao.existsUserByEmail(email);
    }

    @Override
    public Boolean verifyUniqueDocumentNumber(String documentNumber) {
        return userDao.existsUserByDocumentNumber(documentNumber);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findEmployeesByCompany(Integer id) {
        return userDao.findByCompanyId(id);
    }

    @Override
    public List<Privilege> findPrivileges() {
        return (List<Privilege>) iPrivilegeDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userDao.findByEmail(email);

        if (user == null) {
            logger.error("Usuario no autorizado");
            throw new UsernameNotFoundException("Usuario no autorizados");
        }

        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map( role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities);
    }
}
