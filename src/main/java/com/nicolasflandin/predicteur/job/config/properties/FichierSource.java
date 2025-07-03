package com.nicolasflandin.predicteur.job.config.properties;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fichier-source")
@AnnotationJob
public class FichierSource {

    private String path;
    private char delimeter;

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public char getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(final char delimeter) {
        this.delimeter = delimeter;
    }
}
