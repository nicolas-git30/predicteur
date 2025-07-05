package com.nicolasflandin.predicteur.domain.dto.analyse;

import com.nicolasflandin.predicteur.domain.dto.combinaison.EtoileCombinaison;
import com.nicolasflandin.predicteur.domain.dto.combinaison.ItemCombinaison;
import com.nicolasflandin.predicteur.domain.dto.combinaison.NumeroCombinaison;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ItemAnalyse implements Serializable {

    private Integer numero;
    private Integer nombreSorties = 0;
    private Integer nombreJoursDelta;
    private LocalDate ancienneDateSortie;
    private LocalDate nouvelleDateSortie;
    private BigDecimal probabilite;
    private Map<Integer, ItemCombinaison> etoileCombinaison;
    private Map<Integer, ItemCombinaison> numeroCombinaison;

    public ItemAnalyse(final Integer numero) {
        this.numeroCombinaison = new HashMap<>();
        this.etoileCombinaison = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            this.etoileCombinaison.put(i, new EtoileCombinaison(i));
        }
        for (int i = 1; i < 51; i++) {
            this.numeroCombinaison.put(i, new NumeroCombinaison(i));
        }
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(final Integer numero) {
        this.numero = numero;
    }

    public Map<Integer, ItemCombinaison> getEtoileCombinaison() {
        return etoileCombinaison;
    }

    public void setEtoileCombinaison(final Map<Integer, ItemCombinaison> etoileCombinaison) {
        this.etoileCombinaison = etoileCombinaison;
    }

    public Map<Integer, ItemCombinaison> getNumeroCombinaison() {
        return numeroCombinaison;
    }

    public void setNumeroCombinaison(final Map<Integer, ItemCombinaison> numeroCombinaison) {
        this.numeroCombinaison = numeroCombinaison;
    }
}
