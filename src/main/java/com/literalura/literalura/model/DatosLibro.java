package com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // ignoro las propiedades desconocidas
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") Double numeroDescargas,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("authors") List<DatosAutor> autores) {

    @Override
    public String toString() {
        return  "\nTítulo: " + titulo + "\n" +
                "Autor(es): \n" +
                autores.stream()
                        .map(autor -> "  - " + autor.autor())
                        .reduce("", String::concat) + "\n" +
                "Idioma(s): " + String.join(", ", idioma) + "\n" +
                "Descargas: " + numeroDescargas + "\n" +
                "----------------------------------------";
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public List<DatosAutor> getAutores() {
        return autores;
    }



}

