package com.nicolasflandin.predicteur.application.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AnnotationDomain {
    String couche() default "domain";
}
