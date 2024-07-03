package com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import java.util.Map;

public record DatosLibro(
        @JsonAlias("id") int id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("translators") List<String> traductores,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("bookshelves") List<String> estanterias,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("copyright") boolean derechosDeAutor,
        @JsonAlias("media_type") String tipoDeMedio,
        @JsonAlias("formats") Map<String, String> formatos,
        @JsonAlias("download_count") int cuentaDescargas

) {
}
