package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

import java.io.Serializable;
import java.time.LocalDate;

@AnnotationDomain
public class EtoileDto implements Serializable {

    private Integer numeroEtoile;
    private Integer nombreSorties;
    private LocalDate dateSortie;

    public Integer getNumeroEtoile() {
        return numeroEtoile;
    }

    public void setNumeroEtoile(final Integer numeroEtoile) {
        this.numeroEtoile = numeroEtoile;
    }

    public Integer getNombreSorties() {
        return nombreSorties;
    }

    public void setNombreSorties(final Integer nombreSorties) {
        this.nombreSorties = nombreSorties;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(final LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }
}
