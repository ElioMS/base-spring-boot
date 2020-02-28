package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Dial;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/twillio")
public class TwilioController {

	public static final String ACCOUNT_SID = "AC9db0997479679f07884b5449201eab43";
	public static final String AUTH_TOKEN = "0b58677a4d25f65dde5b63c5ba76829b";
	public static final String TWILIO_NUMBER = "+12052738621";

	@PostMapping("/sms")
	public ResponseEntity<?> sendSms(@RequestBody Map<String, String> body) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message.creator(
				new PhoneNumber(body.get("phone")),
				new PhoneNumber(TWILIO_NUMBER),
				"SMS Cambio y moneda")
				.create();

//		Message.creator()

		return ResponseEntity.ok(new MessageResponse("El SMS de confirmación ha sido enviado"));
	}

	@GetMapping(value = "/twiml", produces = "application/xml")
	@ResponseBody
	public ResponseEntity<String> getStreamsTwiml(UriComponentsBuilder uriInfo) {
		String wssUrl = "wss://" + uriInfo.build().getHost() + "/messages";

//		return new VoiceResponse.Builder()
//				.say(new Say.Builder("GAAAAAAAAAAAA").build())
//				.dial(new Dial.Builder().number("").build())
//				.build()
//				.toXml();

		return ResponseEntity.ok("aaa"+ wssUrl);
	}

	@PostMapping("/call")
	public ResponseEntity<?> requestCall(@RequestBody Map<String, String> body) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//		Call.creator()
//				.create();

		return ResponseEntity.ok(new MessageResponse("El SMS de confirmación ha sido enviado"));
	}
}
