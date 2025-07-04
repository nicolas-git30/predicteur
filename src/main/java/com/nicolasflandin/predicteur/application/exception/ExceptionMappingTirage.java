package com.nicolasflandin.predicteur.application.exception;

public class ExceptionMappingTirage extends RuntimeException {
    public ExceptionMappingTirage(String message) {
        super(message);
    }

    public ExceptionMappingTirage(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionMappingTirage(final Exception e) {}
}
