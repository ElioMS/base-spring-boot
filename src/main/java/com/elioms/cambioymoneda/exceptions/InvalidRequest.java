package com.elioms.cambioymoneda.exceptions;

import org.springframework.validation.Errors;

import java.util.List;

public class InvalidRequest {
    public static void check(Errors errors) {
        if (errors.hasFieldErrors()) {
            throw new InvalidException(errors);
        }
    }
}
