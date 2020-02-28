package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.services.resetPassword.ResetPasswordService;
import com.elioms.cambioymoneda.utils.MailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/passwordReset")
public class ResetPasswordController {

    private static final String NOTIFY_RESPONSE = "Se ha enviado un mensaje de confirmación a su correo";
    private static final String CYM_URI = "http://localhost:8080/passwordReset";

    @Autowired
    private ResetPasswordService resetPasswordService;

    @Autowired
    private MailService mailService;

    @PostMapping("/notify")
    public ResponseEntity<?> notify(@Valid @RequestBody Map<String, String> body) {
        var newErrors = new BindException(this, "");
        var email = body.get("email");

        if (email.equals("") || email == null) {
            newErrors.addError(new FieldError("", "email", "El email es un campo requerido."));
        }

        InvalidRequest.check(newErrors);

        String code = RandomStringUtils.randomAlphanumeric(6);

        mailService.sendMail(email, "RECUPERAR CONTRASEÑA", "ENLACE: "+CYM_URI);

        return ResponseEntity.ok(new MessageResponse(NOTIFY_RESPONSE));
    }

    @PostMapping("/app")
    public ResponseEntity<?> resetPasswordApp(@Valid @RequestBody Map<String, String> body) {

        resetPasswordService.resetPasswordApp(body.get("email"), body.get("password"));

        return ResponseEntity.ok(new MessageResponse("La contraseña ha sido actualizada"));

    }

}
