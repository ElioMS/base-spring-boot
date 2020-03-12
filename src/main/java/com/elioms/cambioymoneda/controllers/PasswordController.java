package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.models.request.ChangePasswordRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class PasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("changepassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest body, Errors errors) {
        InvalidRequest.check(errors);

        User user = userService.findById(body.getId());
        user.setPassword(passwordEncoder.encode(body.getPassword()));

        userService.save(user);

        return ResponseEntity.ok(new MessageResponse("La contraseña ha sido actualizada"));
    }


}