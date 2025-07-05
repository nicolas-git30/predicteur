package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import java.util.HashMap;
import java.util.Map;

@AnnotationDomain
public class NumeroAnalyse extends ItemAnalyse {

    private Integer numero;
    private Map<Integer, ItemCombinaison> numeroCombinaison;
    private Map<Integer, ItemCombinaison> etoileCombinaison;

    public NumeroAnalyse() {}

    public NumeroAnalyse(final Integer numero) {
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

    public Map<Integer, ItemCombinaison> getNumeroCombinaison() {
        return numeroCombinaison;
    }

    public void setNumeroCombinaison(final Map<Integer, ItemCombinaison> numeroCombinaison) {
        this.numeroCombinaison = numeroCombinaison;
    }

    public Map<Integer, ItemCombinaison> getEtoileCombinaison() {
        return etoileCombinaison;
    }

    public void setEtoileCombinaison(final Map<Integer, ItemCombinaison> etoileCombinaison) {
        this.etoileCombinaison = etoileCombinaison;
    }
}
