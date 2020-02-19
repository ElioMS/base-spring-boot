package com.elioms.cambioymoneda.handlers;

import com.elioms.cambioymoneda.exceptions.InvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InvalidRequestHandler {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, ArrayList<String>> processValidationError(InvalidException ex) {
        Map<String, ArrayList<String>> errors = new HashMap<>();

        for (FieldError err: ex.getErrors().getFieldErrors()) {
            if (errors.containsKey(err.getField())) {
                errors.get(err.getField()).add(err.getDefaultMessage());
            } else {
                ArrayList<String> validation = new ArrayList<>();
                validation.add(err.getDefaultMessage());
                errors.put(err.getField(), validation);
            }
        }

        return errors;
    }

}
