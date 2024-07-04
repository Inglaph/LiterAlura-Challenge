package com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusqueda(
        @JsonAlias("count") Integer cantidad,
        @JsonAlias("results") List<DatosLibro> librosEncontrados) {

    @Override
    public String toString() {
        return "Cantidad de libros encontrados: " + cantidad + "\n" +
                "----------------------------------------\n" +
                librosEncontrados.stream()
                        .map(DatosLibro::toString)
                        .reduce("", String::concat);
    }

    @Override
    public List<DatosLibro> librosEncontrados() {
        return librosEncontrados;
    }
}
