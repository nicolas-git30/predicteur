package com.nicolasflandin.predicteur.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemAnalyse implements Serializable {

    private Integer nombreSorties = 0;
    private Integer nombreJoursDelta = 0;
    private LocalDate ancienneDateSortie;
    private LocalDate nouvelleDateSortie;
    private BigDecimal probabilite;

    public Integer getNombreSorties() {
        return nombreSorties;
    }

    public void setNombreSorties(final Integer nombreSorties) {
        this.nombreSorties = nombreSorties;
    }

    public Integer getNombreJoursDelta() {
        return nombreJoursDelta;
    }

    public void setNombreJoursDelta(final Integer nombreJoursDelta) {
        this.nombreJoursDelta = nombreJoursDelta;
    }

    public LocalDate getAncienneDateSortie() {
        return ancienneDateSortie;
    }

    public void setAncienneDateSortie(final LocalDate ancienneDateSortie) {
        this.ancienneDateSortie = ancienneDateSortie;
    }

    public LocalDate getNouvelleDateSortie() {
        return nouvelleDateSortie;
    }

    public void setNouvelleDateSortie(final LocalDate nouvelleDateSortie) {
        this.nouvelleDateSortie = nouvelleDateSortie;
    }

    public BigDecimal getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(final BigDecimal probabilite) {
        this.probabilite = probabilite;
    }
}
