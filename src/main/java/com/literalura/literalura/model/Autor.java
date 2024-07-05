package com.literalura.literalura.model;

import java.time.LocalDate;

public class Autor {
    private String autor;
    private LocalDate anoNacimiento;
    private LocalDate anoFallecimiento;

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
}

