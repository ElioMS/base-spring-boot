package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.Transference;
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
import java.util.HashMap;

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

        HashMap<String, Object> hashmap = new HashMap<String, Object>();

        hashmap.put("salesCurrency", 3.33);
        hashmap.put("purchaseCurrency", 3.60);

        return ResponseEntity.ok(hashmap);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> store(@Valid @RequestBody CreateTransferRequest transference, Errors errors) {
        InvalidRequest.check(errors);

        Transference transfer = transferenceService.create(transference);

        return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CreateTransferRequest transference, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);

        return ResponseEntity.ok(transferenceService.update(transference, id));
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
