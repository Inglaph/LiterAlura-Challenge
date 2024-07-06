package com.literalura.literalura.model;

public enum Lenguaje {
    ESPANOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGUES("pt");

    private  String lenguajeAPI;

    Lenguaje(String lenguajeAPI) {
        this.lenguajeAPI = lenguajeAPI;
    }

    // metodo para obtener el lenguaje de la API de acuerdo al lenguaje que se le pase como parametro
    public static Lenguaje obtenerLenguaje(String lenguaje) {
        for (Lenguaje lenguajeAPI : Lenguaje.values()) {
            if (lenguajeAPI.lenguajeAPI.equals(lenguaje)) {
                return lenguajeAPI;
            }
        }
        return null;
    }

}
