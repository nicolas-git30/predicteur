package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AnnotationApplication
public class TirageDto implements Serializable {

    private LocalDate dateTirage;
    private Integer numeroDuTirage;
    private List<Integer> etoileTirage = new ArrayList<>();
    private List<Integer> numeroTirage = new ArrayList<>();

    public LocalDate getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(final LocalDate dateTirage) {
        this.dateTirage = dateTirage;
    }

    public Integer getNumeroDuTirage() {
        return numeroDuTirage;
    }

    public void setNumeroDuTirage(final Integer numeroDuTirage) {
        this.numeroDuTirage = numeroDuTirage;
    }

    public List<Integer> getEtoileTirage() {
        return etoileTirage;
    }

    public void setEtoileTirage(final List<Integer> etoileTirage) {
        this.etoileTirage = etoileTirage;
    }

    public List<Integer> getNumeroTirage() {
        return numeroTirage;
    }

    public void setNumeroTirage(final List<Integer> numeroTirage) {
        this.numeroTirage = numeroTirage;
    }
}
