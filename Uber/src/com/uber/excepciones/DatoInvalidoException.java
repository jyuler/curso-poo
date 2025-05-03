package com.uber.excepciones;

/**
 * Excepción personalizada para representar errores relacionados con datos inválidos.
 */
public class DatoInvalidoException extends Exception {

    /**
     * Constructor con mensaje personalizado.
     * @param message El mensaje de error.
     */
    public DatoInvalidoException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta una causa (otra excepción).
     * @param message El mensaje de error.
     * @param cause La causa original de la excepción.
     */
    public DatoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
