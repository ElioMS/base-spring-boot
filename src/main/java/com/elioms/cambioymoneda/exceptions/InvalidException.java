package com.elioms.cambioymoneda.exceptions;

import org.springframework.validation.Errors;

public class InvalidException extends RuntimeException {

    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public InvalidException(Errors errors) {
        this.errors = errors;
    }

}


