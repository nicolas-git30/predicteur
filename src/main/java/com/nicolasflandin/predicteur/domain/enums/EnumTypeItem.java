package com.nicolasflandin.predicteur.domain.enums;

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
