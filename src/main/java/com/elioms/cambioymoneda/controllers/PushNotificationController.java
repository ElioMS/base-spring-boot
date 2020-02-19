package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.request.FcmRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.utils.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping("/push")
    public ResponseEntity<?> pushNotification(@RequestBody FcmRequest data) {
        pushNotificationService.sendNotification(data);

        return ResponseEntity.ok(new MessageResponse("Notificación enviada!!"));
    }
}
