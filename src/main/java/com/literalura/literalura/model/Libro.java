package com.literalura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private String titulo;

    private Integer numeroDescargas;

    private List<Autor> autores;

    public Libro(DatosLibro libro) {
        this.titulo = libro.titulo();
        this.numeroDescargas = libro.numeroDescargas();
        this.autores = libro.autores().stream()
                .map(Autor::new)
                .toList(); // convierte el stream en una lista no modifcable (inmutable) de autores
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "\nTítulo: " + titulo + "\n" +
                "Descargas: " + numeroDescargas + "\n" +
                "----------------------------------------";
    }
}
