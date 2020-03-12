package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.request.PreRegisterRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.models.response.PreRegisterResponse;
import com.elioms.cambioymoneda.services.UserService;
import com.elioms.cambioymoneda.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/preregister")
public class PreRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> preRegister(@Valid @RequestBody User user, Errors errors) {
        InvalidRequest.check(errors);

        String passwordEncrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncrypt);

        var newErrors = new BindException(this, "");

        if (userService.verifyUniqueEmail(user.getEmail())) {
            newErrors.addError(new FieldError("", "email", "El email ya ha sido tomado."));
        }

        InvalidRequest.check(newErrors);

        userService.save(user);
        mailService.sendMail(user.getEmail(), "PRE-REGISTRO", "PRE REGISTRO FINALIZADO");

        return ResponseEntity.ok(new MessageResponse("Pre-registro finalizado"));
    }

}
