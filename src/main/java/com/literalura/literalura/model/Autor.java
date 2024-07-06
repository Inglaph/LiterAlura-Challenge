package com.literalura.literalura.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String autor;
    private LocalDate anoNacimiento;
    private LocalDate anoFallecimiento;

    @ManyToOne
    @JoinColumn(name = "libro_id") // Con esta anotacion le indico que se va a relacionar con la tabla libros
    private Libro libro;

    public Autor() {
    }

    public Autor(DatosAutor autor) {
        this.autor = autor.autor();
        this.anoNacimiento = LocalDate.of(autor.anoNacimiento(), 1, 1);
        this.anoFallecimiento = LocalDate.of(autor.anoFallecimiento(), 1, 1);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(LocalDate anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public LocalDate getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public void setAnoFallecimiento(LocalDate anoFallecimiento) {
        this.anoFallecimiento = anoFallecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return "Autor: " + autor  +
                " (" + anoNacimiento.format(formatter) + " - " + anoFallecimiento.format(formatter) + ")\n";
    }
}

