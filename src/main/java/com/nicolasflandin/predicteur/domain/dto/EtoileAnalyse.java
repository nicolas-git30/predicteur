package com.nicolasflandin.predicteur.domain.dto;

import java.util.HashMap;
import java.util.Map;

public class EtoileAnalyse extends ItemAnalyse {

    private Integer etoile = 0;
    private Map<Integer, ItemCombinaison> etoileCombinaison;

    public EtoileAnalyse() {}

    public EtoileAnalyse(final Integer etoile) {
        this.etoileCombinaison = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            this.etoileCombinaison.put(i, new ItemCombinaison(i));
        }
        this.etoile = etoile;
    }

    public Integer getEtoile() {
        return etoile;
    }

    public void setEtoile(final Integer etoile) {
        this.etoile = etoile;
    }

    public Map<Integer, ItemCombinaison> getEtoileCombinaison() {
        return etoileCombinaison;
    }

    public void setEtoileCombinaison(final Map<Integer, ItemCombinaison> etoileCombinaison) {
        this.etoileCombinaison = etoileCombinaison;
    }
}
