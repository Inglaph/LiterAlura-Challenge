package com.literalura.literalura.model;

import java.util.List;

public class Libro {
    private String titulo;
    private Integer numeroDescargas;
    private List<Autor> autores;

    public Libro(DatosLibro libro) {
        this.titulo = libro.titulo();
        this.numeroDescargas = libro.numeroDescargas();
        this.autores = libro.autores().stream()
                .map(Autor::new)
                .toList();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return  "\nTítulo Libro a guardar en BD: " + titulo + "\n" +
                "Autor(es): \n" +
                autores.stream()
                        .map(autor -> "  - " + autor.getAutor())
                        .reduce("", String::concat) + "\n" +
                "Descargas: " + numeroDescargas + "\n" +
                "----------------------------------------";
    }
}
