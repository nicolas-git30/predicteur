package com.nicolasflandin.predicteur.domain.dto.combinaison;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

@AnnotationDomain
public class EtoileCombinaison extends ItemCombinaison {
    public EtoileCombinaison() {}

    public EtoileCombinaison(final int i) {
        super(i);
    }
}
