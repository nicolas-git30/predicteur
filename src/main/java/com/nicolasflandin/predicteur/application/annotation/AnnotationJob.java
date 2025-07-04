package com.nicolasflandin.predicteur.application.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AnnotationJob {
    String couche() default "job";
}
