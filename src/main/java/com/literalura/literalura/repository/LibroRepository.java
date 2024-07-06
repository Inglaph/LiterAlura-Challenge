package com.literalura.literalura.repository;

import com.literalura.literalura.model.Autor;
import com.literalura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface LibroRepository extends JpaRepository<Libro, Long> {

    // query que devuelve una lista de autores de todos los libros
    @Query("SELECT a FROM Libro l JOIN l.autores a")
    List<Autor> autoresDeLibros();

    // query que devuelve una lista de autores vivos en un determinado año
    @Query("SELECT a FROM Autor a WHERE a.anoNacimiento < :fecha AND a.anoFallecimiento > :fecha")
    List<Autor> autoresVivosEnAnio(LocalDate fecha);

    // query que devuelve una lista de libros por idioma
    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> librosPorIdioma(String idioma);
}
