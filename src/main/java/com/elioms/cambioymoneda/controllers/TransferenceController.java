package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.request.ConversionRequest;
import com.elioms.cambioymoneda.models.request.CreateTransferRequest;
import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.services.transference.TransferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferenceController {

    @Autowired
    private TransferenceService transferenceService;
    
    @GetMapping
    public ResponseEntity<?> index() {
    	var list = transferenceService.findAll();
    	return ResponseEntity.ok(list);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
    	var transfer = transferenceService.findById(id);
    	return ResponseEntity.ok(transfer);
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@Valid @RequestBody ConversionRequest body) {
        var calculate = body.getInAmmount() * body.getCurrencyValue();
        return ResponseEntity.ok(new MessageResponse("El monto calculado: "+calculate));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> store(@Valid @RequestBody CreateTransferRequest transference, Errors errors) {
        InvalidRequest.check(errors);

        transferenceService.create(transference);

        return new ResponseEntity<>(new MessageResponse("La solicitud de transferencia ha sido generada"), HttpStatus.CREATED);
    }

    @GetMapping("History")
    public ResponseEntity<?> history(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {

        var history = transferenceService.history(page, size, "DESC", "id");
        return ResponseEntity.ok(history);
    }

    @GetMapping("lastTen")
    public ResponseEntity<?> lastTenTransference() {
        var lastTen = transferenceService.lastTenTransference();
        return ResponseEntity.ok(lastTen);
    }
}
