package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.request.FcmRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.models.response.MigoResponse;
import com.elioms.cambioymoneda.utils.PushNotificationService;
import com.elioms.cambioymoneda.utils.RestClient;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @PostMapping("/currency")
    public ResponseEntity<?> currencyNotification() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("token", "0dd00033-9bd6-488b-b5f8-9db370bbb012-99452d12-4eca-4167-823d-11f7adbb604b");

        RestClient client = new RestClient("https://api.migoperu.pe/api/v1/exchange/latest", null);
        String response = client.postFormData(map);

        Gson gson = new Gson();
        MigoResponse migo = gson.fromJson(response, MigoResponse.class);

        return ResponseEntity.ok(migo);
    }
}
