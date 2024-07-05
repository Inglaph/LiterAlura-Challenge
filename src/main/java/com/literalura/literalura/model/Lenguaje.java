package com.literalura.literalura.model;

public enum Lenguaje {
    ESPANOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGUES("pt");

    private final String lenguajeAPI;

    Lenguaje(String lenguajeAPI) {
        this.lenguajeAPI = lenguajeAPI;
    }
}
