package com.elioms.cambioymoneda.utils;

import com.elioms.cambioymoneda.models.request.FcmRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    public void sendNotification(FcmRequest fcmRequest) {

        JSONObject body = new JSONObject();
        body.put("to", fcmRequest.getToken());
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", fcmRequest.getTitle());
        notification.put("body", fcmRequest.getBody());

        JSONObject data = new JSONObject();
        data.put("title", fcmRequest.getTitle());
        data.put("body", fcmRequest.getBody());

        JSONObject message = new JSONObject();
        message.put("message", data);

        body.put("data", message);
        body.put("notification", notification);

        RestClient client = new RestClient("https://fcm.googleapis.com/fcm/send", "key=AIzaSyDu2U1-6kuzYnfVSQxCwPjOGG2xR2T0Glo");
        client.post(body.toString());
    }

}
