package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.request.RegisterRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.services.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MessageResponse> register(@Valid @RequestBody RegisterRequest body, Errors errors) {
        InvalidRequest.check(errors);

        registerService.register(body);

        return ResponseEntity.ok(new MessageResponse("Registro finalizado"));
    }

}
