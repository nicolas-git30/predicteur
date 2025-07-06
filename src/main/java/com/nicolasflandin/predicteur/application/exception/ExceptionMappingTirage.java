package com.nicolasflandin.predicteur.application.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;

@AnnotationApplication
public class ExceptionMappingTirage extends RuntimeException {
    public ExceptionMappingTirage(String message) {
        super(message);
    }

    public ExceptionMappingTirage(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionMappingTirage(final Exception e) {}
}
