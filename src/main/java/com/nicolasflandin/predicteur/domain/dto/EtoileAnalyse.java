package com.nicolasflandin.predicteur.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EtoileAnalyse implements Serializable {

    private Integer etoile = 0;
    private Integer nombreSorties = 0;
    private Integer nombreJoursDelta = 0;
    private LocalDate ancienneDateSortie;
    private LocalDate nouvelleDateSortie;
    private Map<Integer, EtoileCombinaison> etoileCombinaison;
    private BigDecimal probabilite;

    public EtoileAnalyse() {}

    public EtoileAnalyse(final Integer etoile) {
        this.etoileCombinaison = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            this.etoileCombinaison.put(i, new EtoileCombinaison(i));
        }
        this.etoile = etoile;
    }

    public Integer getEtoile() {
        return etoile;
    }

    public void setEtoile(final Integer etoile) {
        this.etoile = etoile;
    }

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

    public Map<Integer, EtoileCombinaison> getEtoileCombinaison() {
        return etoileCombinaison;
    }

    public void setEtoileCombinaison(final Map<Integer, EtoileCombinaison> etoileCombinaison) {
        this.etoileCombinaison = etoileCombinaison;
    }

    public BigDecimal getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(final BigDecimal probabilite) {
        this.probabilite = probabilite;
    }
}
