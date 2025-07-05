package com.nicolasflandin.predicteur.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemCombinaison implements Serializable {
    private Integer numero;
    private Integer nombreCombinaison = 0;
    private BigDecimal probabilite;

    public ItemCombinaison() {}

    public ItemCombinaison(final int i) {
        this.numero = i;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(final Integer numero) {
        this.numero = numero;
    }

    public Integer getNombreCombinaison() {
        return nombreCombinaison;
    }

    public void setNombreCombinaison(final Integer nombreCombinaison) {
        this.nombreCombinaison = nombreCombinaison;
    }

    public BigDecimal getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(final BigDecimal probabilite) {
        this.probabilite = probabilite;
    }
}
