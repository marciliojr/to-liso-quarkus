package com.gestor.exceptions;

public class InfraException extends Exception {

    public InfraException(String message) {
        super(message);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }
}
