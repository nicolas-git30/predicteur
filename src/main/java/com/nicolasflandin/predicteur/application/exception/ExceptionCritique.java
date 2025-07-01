package com.nicolasflandin.predicteur.application.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;

@AnnotationApplication
public class ExceptionCritique extends RuntimeException {
    public ExceptionCritique(String message) {
        super(message);
    }

    public ExceptionCritique(String message, Throwable cause) {
        super(message, cause);
    }
}
