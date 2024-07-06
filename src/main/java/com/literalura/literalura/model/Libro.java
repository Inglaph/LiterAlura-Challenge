package com.literalura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true, nullable = false)
    private String titulo;
    private String idioma;
    private Integer numeroDescargas;

    // Con la anotacion @OneToMany le indico que es una relacion de uno a muchos
    @OneToMany (mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Con fetch le indico que traiga los autores
    private List<Autor> autores;

    public Libro(DatosLibro libro) {
        this.titulo = libro.titulo();
        this.idioma = libro.idioma().get(0)
         ; // se agrega el idioma
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return  "\nTítulo: " + titulo + "\n" +
                "Descargas: " + numeroDescargas + "\n" +
                "----------------------------------------";
    }
}
