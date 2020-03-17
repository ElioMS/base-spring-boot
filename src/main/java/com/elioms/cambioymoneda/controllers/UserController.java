package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.dao.IRoleDao;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.request.CreateUserRequest;
import com.elioms.cambioymoneda.models.request.UpdateEmployeeRequest;
import com.elioms.cambioymoneda.services.UserService;
import com.elioms.cambioymoneda.utils.MailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = {})
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    private IRoleDao roleDao;

    public UserController(IRoleDao iRoleDao) {
        this.roleDao = iRoleDao;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public List<User> index() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> store(@Valid @RequestBody User user, Errors errors) {
        InvalidRequest.check(errors);

        User newUser = userService.save(user);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> listEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findEmployeesByCompany(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateUserRequest body, Errors errors) {
        InvalidRequest.check(errors);

        var newErrors = new BindException(this, "");

        if (userService.verifyUniqueEmail(body.getEmail())) {
            newErrors.addError(new FieldError("", "email", "El email ya ha sido tomado."));
        }

        if (userService.verifyUniqueDocumentNumber(body.getDocumentNumber())) {
            newErrors.addError(new FieldError("", "documentNumber", "El número de documento ya ha sido tomado."));
        }

        InvalidRequest.check(newErrors);

        var role = this.roleDao.findById(Long.valueOf(2)).orElse(null);

        User newEmployee = new User();
        newEmployee.setName(body.getName());
        newEmployee.setSurname(body.getSurname());
        newEmployee.setDocumentType(body.getDocumentType());
        newEmployee.setDocumentNumber(body.getDocumentNumber());
        newEmployee.setEmail(body.getEmail());
        newEmployee.setPhoneNumber(body.getPhoneNumber());
        newEmployee.setFirstCellphone(body.getFirstCellphone());
        newEmployee.setSecondCellphone(body.getSecondCellphone());
        newEmployee.setRoles(Arrays.asList(role));
        newEmployee.setPrivileges(body.getPrivileges());
        newEmployee.setCompanyId(body.getCompanyId());
        newEmployee.setType(2);

        String randomString = RandomStringUtils.randomAlphanumeric(10);
        String generatedPassword = passwordEncoder.encode(randomString);
        newEmployee.setPassword(generatedPassword);

        userService.save(newEmployee);

        mailService.sendMail(body.getEmail(), "REGISTRO SUB-USUARIO", "TU CONTRASEÑA ES: "+ randomString);

        return ResponseEntity.ok(body);
    }

    @PutMapping("/employees/{id}")
    public User updateEmployee(@Valid @RequestBody UpdateEmployeeRequest body, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);

        return userService.updateEmployee(body, id);
    }

    @PutMapping("/users/{id}")
    public User update(@Valid @RequestBody User user, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);

        User currentUser = userService.findById(id);
        currentUser.setName(user.getName());

        return userService.save(currentUser);
    }

    @GetMapping("/users/{id}/transference")
    public ResponseEntity<?> lastTransferenceByUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.lastTransferenceByUser(id));
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
