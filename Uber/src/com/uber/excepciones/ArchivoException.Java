package com.uber.excepciones;

public class ArchivoException extends Exception {
    public ArchivoException(String message) {
        super(message);
    }

    public ArchivoException(String message, Throwable cause) {
        super(message, cause);
    }
}
