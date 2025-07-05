package com.nicolasflandin.predicteur.domain.exception;

public class ExceptionUpdateItemAnalyse extends RuntimeException {

    public ExceptionUpdateItemAnalyse(String message) {
        super(message);
    }

    public ExceptionUpdateItemAnalyse(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionUpdateItemAnalyse(final Exception e) {}
}
