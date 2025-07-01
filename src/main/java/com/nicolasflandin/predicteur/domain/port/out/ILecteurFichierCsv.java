package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.infrastructure.exception.ExceptionReadFile;

@AnnotationDomain
public interface ILecteurFichierCsv<T> {
    public T lectureFichier(String cheminFichier) throws ExceptionReadFile;
}
