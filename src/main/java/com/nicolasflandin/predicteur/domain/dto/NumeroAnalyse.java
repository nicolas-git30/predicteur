package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@AnnotationDomain
public class NumeroAnalyse implements Serializable {

    private Integer numero;
    private Integer nombreSorties;
    private Integer nombreJoursDelta;
    private LocalDate lastDateSortie;
    private Map<Integer, NumeroCombinaison> numeroCombinaison;
    private Map<Integer, EtoileCombinaison> etoileCombinaison;
    private Integer nombreSortiesTroisAns;
    private BigDecimal moyenneSortiesTroisAns;
    private BigDecimal probabilite;

    public NumeroAnalyse() {}
    public NumeroAnalyse( final Integer numero ) {
        this.numeroCombinaison = new HashMap<>();
        this.etoileCombinaison = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            this.etoileCombinaison.put(i, new EtoileCombinaison(i));
        }
        for (int i = 1; i < 50; i++) {
            this.numeroCombinaison.put(i, new NumeroCombinaison(i));
        }
        this.numero = numero;
    }

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

    public Integer getNombreJoursDelta() {
        return nombreJoursDelta;
    }

    public void setNombreJoursDelta(final Integer nombreJoursDelta) {
        this.nombreJoursDelta = nombreJoursDelta;
    }

    public LocalDate getLastDateSortie() {
        return lastDateSortie;
    }

    public void setLastDateSortie(final LocalDate lastDateSortie) {
        this.lastDateSortie = lastDateSortie;
    }

    public Map<Integer, NumeroCombinaison> getNumeroCombinaison() {
        return numeroCombinaison;
    }

    public void setNumeroCombinaison(final Map<Integer, NumeroCombinaison> numeroCombinaison) {
        this.numeroCombinaison = numeroCombinaison;
    }

    public Map<Integer, EtoileCombinaison> getEtoileCombinaison() {
        return etoileCombinaison;
    }

    public void setEtoileCombinaison(final Map<Integer, EtoileCombinaison> etoileCombinaison) {
        this.etoileCombinaison = etoileCombinaison;
    }

    public Integer getNombreSortiesTroisAns() {
        return nombreSortiesTroisAns;
    }

    public void setNombreSortiesTroisAns(final Integer nombreSortiesTroisAns) {
        this.nombreSortiesTroisAns = nombreSortiesTroisAns;
    }

    public BigDecimal getMoyenneSortiesTroisAns() {
        return moyenneSortiesTroisAns;
    }

    public void setMoyenneSortiesTroisAns(final BigDecimal moyenneSortiesTroisAns) {
        this.moyenneSortiesTroisAns = moyenneSortiesTroisAns;
    }

    public BigDecimal getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(final BigDecimal probabilite) {
        this.probabilite = probabilite;
    }
}
