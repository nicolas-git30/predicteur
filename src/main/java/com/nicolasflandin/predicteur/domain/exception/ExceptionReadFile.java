package com.nicolasflandin.predicteur.domain.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

import java.io.IOException;

@AnnotationDomain
public class ExceptionReadFile extends IOException {

    public ExceptionReadFile(String message) {
        super(message);
    }

    public ExceptionReadFile(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionReadFile(final IOException e) {}
}
