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
    private List<EtoileDto> etoileTirage = new ArrayList<>();
    private List<NumeroDto> numeroTirage = new ArrayList<>();

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

    public List<EtoileDto> getEtoileTirage() {
        return etoileTirage;
    }

    public void setEtoileTirage(final List<EtoileDto> etoileTirage) {
        this.etoileTirage = etoileTirage;
    }

    public List<NumeroDto> getNumeroTirage() {
        return numeroTirage;
    }

    public void setNumeroTirage(final List<NumeroDto> numeroTirage) {
        this.numeroTirage = numeroTirage;
    }
}
