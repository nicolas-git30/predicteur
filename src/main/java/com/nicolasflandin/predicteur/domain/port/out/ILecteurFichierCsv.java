package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;

@AnnotationDomain
public interface ILecteurFichierCsv<T> {
    public T lectureFichier() throws ExceptionReadFile;
}
