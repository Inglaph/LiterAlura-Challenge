package com.literalura.literalura.principal;

import com.literalura.literalura.model.*;
import com.literalura.literalura.repository.LibroRepository;
import com.literalura.literalura.service.ConsumoAPI;
import com.literalura.literalura.service.ConvierteDatos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private String json = "";
    ConvierteDatos conversor = new ConvierteDatos();
    private static int opcionMenu = 6;
    private LibroRepository libroRepository;
    //private AutorRepository autorRepository;
    private List<Libro> libros;
    private String libroBuscado = "";

    public Principal(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }


    public void mostrarMenu() {
        while (opcionMenu != 0) {
            System.out.println("""
                    \n**** Liter Alura ****
                    Menu de opciones de busqueda de libros
                    1- Buscar libro por titulo en API
                    2- Listar libros registrados en BD
                    3- Listar autores registrados en BD
                    4- Listar autores vivos en un determinado año registrados en BD
                    5- listar libros por idioma registrados en BD
                    0- salir
                    """);
            System.out.println("Ingrese la opcion deseada: ");
            try {
                opcionMenu = Integer.parseInt(sc.nextLine());
                //sc.nextLine(); // Limpiar el buffer
                switch (opcionMenu) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosEnUnDeterminadoAnio();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Hasta luego");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número");
                continue;
            }
        }
    }

    private void getDatosBusquedaAPI() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        libroBuscado = sc.nextLine();
        libroBuscado = libroBuscado.replace(" ", "%20");
        String URLBusqueda = URL_BASE + libroBuscado;
        json = consumoApi.obtenerDatos(URLBusqueda);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("""
                Ingrese el idioma de los libros que desea buscar:
                1- Español (es)
                2- Inglés (en)
                3- Francés (fr)
                4- Portugués (pt)
                """);
        String idioma = "";
        String idiomaElegido = "";
        switch (sc.nextLine()) {
            case "1":
                idioma = "es";
                idiomaElegido = "Español";
                break;
            case "2":
                idioma = "en";
                idiomaElegido = "Inglés";
                break;
            case "3":
                idioma = "fr";
                idiomaElegido = "Francés";
                break;
            case "4":
                idioma = "pt";
                idiomaElegido = "Portugués";
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        List<Libro> libros = libroRepository.librosPorIdioma(idioma);
        if (!libros.isEmpty()) {
            System.out.println("Libros en idioma " + idiomaElegido + ": ");
            libros.stream().forEach(libro -> {
                String autores = libro.getAutores().stream()
                        .map(Autor::toString)
                        .collect(Collectors.joining(", "));
                System.out.print(new StringBuilder()
                        .append("Título: ").append(libro.getTitulo()).append("\n")
                        .append("Autor(es): ").append(autores).append("\n")
                        .append("Descargas: ").append(libro.getNumeroDescargas()).append("\n")
                        .append("ID: ").append(libro.getId()).append("\n")
                        .append("----------------------------------------\n")
                        .toString());
            });
        } else {
            System.out.println("No se encontraron libros en el idioma " + idioma + ".");
        }
    }

    private void listarAutoresVivosEnUnDeterminadoAnio() {
        System.out.println("Ingrese el año para buscar autores vivos: ");
        int anio = Integer.parseInt(sc.nextLine());
        LocalDate fecha = LocalDate.of(anio, 1, 1);

        List<Autor> autor = libroRepository.autoresVivosEnAnio(fecha);
        if (!autor.isEmpty() ){
            System.out.println("Autores vivos en el año " + anio + ": ");
            autor.stream().forEach(System.out::print);
        } else {
            System.out.println("No se encontraron autores vivos en el año " + anio + ".");
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = libroRepository.autoresDeLibros();
        System.out.println("Autores registrados en la base de datos: ");
        autores.stream()
                .collect(Collectors.toMap(Autor::getAutor, autor -> autor, (existing, replacement) -> existing))
                .values()
                .stream()
                .sorted(Comparator.comparing(Autor::getAutor))
                .forEach(System.out::print);
    }

    private void listarLibrosRegistrados() {
        libros = libroRepository.findAll();
        // Mostrar los libros registrados en la base de datos
        System.out.println("Libros registrados en la base de datos: ");
        // utilizo .stream() para recorrer la lista de libros y que me muestre los datos de cada libro de una forma bonita
        libros.stream().forEach(libro -> {
            String autores = libro.getAutores().stream()
                    .map(Autor::toString) // Asumiendo que Autor tiene un método toString() bien definido
                    .collect(Collectors.joining(", ")); // Separa los autores con coma
            System.out.println(new StringBuilder()
                    .append("Título: ").append(libro.getTitulo()).append("\n")
                    .append("Autor(es): ").append(autores).append("\n")
                    .append("Idioma: ").append(libro.getIdioma()).append("\n")
                    .append("Descargas: ").append(libro.getNumeroDescargas()).append("\n")
                    .append("ID: ").append(libro.getId()).append("\n")
                    .append("----------------------------------------\n") // Separador para cada libro
                    .toString());
        });
    }

    private void buscarLibroPorTitulo() {
        getDatosBusquedaAPI();
        DatosBusqueda datos = conversor.obtenerDatos(json, DatosBusqueda.class);


        if (datos.librosEncontrados().size() > 0) {

            // Mostrar los datos del primer libro encontrado
            System.out.println("Libros encontrados: ");
            System.out.println("Datos del primer libro filtrado: ");
            System.out.println("Título: " + datos.librosEncontrados().get(0).getTitulo());
           // traer los datos del autor
            System.out.println("Idioma: " + datos.librosEncontrados().get(0).getIdioma());
            System.out.println("Descargas: " + datos.librosEncontrados().get(0).getNumeroDescargas());
            Optional<String> datosAutor = datos.librosEncontrados().get(0).autores().stream()
                    .map(DatosAutor::autor)
                    .findFirst();

            // valido si la fecha de nacimiento o fallecimiento  es nula, no guardo el autor
            if (datos.librosEncontrados().get(0).autores().stream().anyMatch(autor -> autor.anoNacimiento() == null || autor.anoFallecimiento() == null)) {
                System.out.println("No se puede guardar:  El autor debe tener la fecha de nacimiento y fallecimiento.");
                return;
            }

            // valido que el primer libro encontrado no este en la base de datos
            Optional<Libro> libroEncontrado = libroRepository.findByTitulo(datos.librosEncontrados().get(0).getTitulo());
            if (libroEncontrado.isPresent()) {
                System.out.println("El libro ya se encuentra registrado en la base de datos.");
                return;
            }


            System.out.println("Autor: " + datosAutor.toString().formatted("%s", datosAutor.get()));

            // Convertir los datos del libro a la clase Libro
            Libro libro = new Libro(datos.librosEncontrados().get(0));
            System.out.println("\nDatos del libro convertido a la clase Libro para guardar en BD: ");
            System.out.println(libro);
            System.out.println("Autores: ");
            libro.getAutores().forEach(System.out::println);


            // Guardar el libro y sus autores en la base de datos
            for (Autor autor : libro.getAutores()) {
                autor.setLibro(libro); //  Establecer el libro para cada autor
            }

            libroRepository.save(libro); // Guardar el libro y sus autores en la base de datos
        } else { // Si no se encontraron libros
            System.out.println("No se encontraron libros con el título buscado.");
        }
    }
}
