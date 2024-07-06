package com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignoro propiedades desconocidas
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String autor,
        @JsonAlias("birth_year") Integer anoNacimiento,
        @JsonAlias("death_year") Integer anoFallecimiento){

    @Override
    public String toString() {
        return "Nombre: " + autor + "\n" +
                "Año de nacimiento: " + anoNacimiento + "\n" +
                "Año de fallecimiento: " + anoFallecimiento + "\n";
    }
}
