package com.nicolasflandin.predicteur.domain.exception;

import com.nicolasflandin.predicteur.application.annotation.AnnotationInfrastructure;
import java.io.IOException;

@AnnotationInfrastructure
public class ExceptionReadFile extends IOException {
    public ExceptionReadFile(String message) {
        super(message);
    }

    public ExceptionReadFile(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionReadFile(final IOException e) {}
}
