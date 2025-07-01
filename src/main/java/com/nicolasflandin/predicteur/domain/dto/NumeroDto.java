package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

import java.io.Serializable;
import java.time.LocalDate;

@AnnotationDomain
public class NumeroDto implements Serializable {
    private Integer numero;
    private Integer nombreSorties;
    private LocalDate dateSortie;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(final Integer numero) {
        this.numero = numero;
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
