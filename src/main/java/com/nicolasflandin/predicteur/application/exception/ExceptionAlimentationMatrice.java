package com.nicolasflandin.predicteur.application.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;

@AnnotationApplication
public class ExceptionAlimentationMatrice extends RuntimeException {
    public ExceptionAlimentationMatrice(String message) {
        super(message);
    }

    public ExceptionAlimentationMatrice(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAlimentationMatrice(final Exception e) {}
}
