package com.nicolasflandin.predicteur.domain.dto;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import java.io.Serializable;
import java.math.BigDecimal;

@AnnotationDomain
public class EtoileCombinaison implements Serializable {

    private Integer numeroEtoile;
    private BigDecimal probabilite;

    public EtoileCombinaison() {}

    public EtoileCombinaison(final Integer numeroEtoile) {
        this.numeroEtoile = numeroEtoile;
    }

    public Integer getNumeroEtoile() {
        return numeroEtoile;
    }

    public void setNumeroEtoile(final Integer numeroEtoile) {
        this.numeroEtoile = numeroEtoile;
    }

    public BigDecimal getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(final BigDecimal probabilite) {
        this.probabilite = probabilite;
    }
}
