package com.nicolasflandin.predicteur.domain.dto.combinaison;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

@AnnotationDomain
public class NumeroCombinaison extends ItemCombinaison {
    public NumeroCombinaison() {}

    public NumeroCombinaison(final int i) {
        super(i);
    }
}
