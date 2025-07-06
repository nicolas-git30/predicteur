package com.nicolasflandin.predicteur.domain.enums;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;

@AnnotationDomain
public enum EnumTypeItem {
    ETOILE("Etoile"),
    NUMERO("NUMERO");

    private String value;

    EnumTypeItem(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
