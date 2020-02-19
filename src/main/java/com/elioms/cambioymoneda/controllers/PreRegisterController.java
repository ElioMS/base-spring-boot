package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.response.PreRegisterResponse;
import com.elioms.cambioymoneda.services.UserService;
import com.elioms.cambioymoneda.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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

    @PostMapping
    public ResponseEntity<PreRegisterResponse> preRegister(@Valid @RequestBody User user, Errors errors) {
        InvalidRequest.check(errors);

        userService.save(user);

        mailService.sendMail(user.getEmail(), "PRE-REGISTRO", "PRE REGISTRO FINALIZADO");

        PreRegisterResponse response = new PreRegisterResponse();
        response.setMessage("Pre-registro finalizado");

        return ResponseEntity.ok(response);
    }

}
