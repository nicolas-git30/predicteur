package com.nicolasflandin.predicteur.domain.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

import java.io.IOException;

@AnnotationDomain
public class ExceptionTirageParsing extends RuntimeException {
    public ExceptionTirageParsing(String message) {
        super(message);
    }

    public ExceptionTirageParsing(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionTirageParsing(final IOException e) {
    }
}
