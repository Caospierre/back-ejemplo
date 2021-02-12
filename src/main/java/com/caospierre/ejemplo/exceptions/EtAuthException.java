package com.caospierre.ejemplo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EtAuthException extends RuntimeException {

    public EtAuthException(String message) {
        super("usuahrio o contraseña invalida");
    }
}
