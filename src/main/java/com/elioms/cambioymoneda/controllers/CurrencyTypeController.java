package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.FavoriteCurrencyType;
import com.elioms.cambioymoneda.models.request.FavoriteCurrencyTypeRequest;

import com.elioms.cambioymoneda.models.response.MessageResponse;
import com.elioms.cambioymoneda.services.favoriteCurrencyType.FavoriteCurrencyTypeService;
import com.twilio.http.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/currencyTypes")
public class CurrencyTypeController {

//    public List<>
    private FavoriteCurrencyTypeService favoriteCurrencyTypeService;

    public CurrencyTypeController(FavoriteCurrencyTypeService favoriteCurrencyTypeService) {
        this.favoriteCurrencyTypeService = favoriteCurrencyTypeService;
    }

    @GetMapping("favorites/{userId}")
    public List<FavoriteCurrencyType> favoritesByUser(@PathVariable Long userId) {
        return favoriteCurrencyTypeService.findByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FavoriteCurrencyType store(@Valid @RequestBody FavoriteCurrencyTypeRequest body, Errors errors) {
        InvalidRequest.check(errors);

        return favoriteCurrencyTypeService.save(body);
    }

    @PutMapping("favorites/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody FavoriteCurrencyTypeRequest body, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);

        return ResponseEntity.ok(favoriteCurrencyTypeService.update(body, id));
    }

    @DeleteMapping("/favorites/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {

        favoriteCurrencyTypeService.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("OK"));
    }
}
