package com.literalura.literalura.principal;

import com.literalura.literalura.model.Autor;
import com.literalura.literalura.model.DatosAutor;
import com.literalura.literalura.model.DatosBusqueda;
import com.literalura.literalura.model.Libro;
import com.literalura.literalura.repository.LibroRepository;
import com.literalura.literalura.service.ConsumoAPI;
import com.literalura.literalura.service.ConvierteDatos;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private String json = "";
    ConvierteDatos conversor = new ConvierteDatos();
    private static int opcionMenu = 6;
    private LibroRepository repository;

    public Principal(LibroRepository libroRepository) {
        this.repository = libroRepository;
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
        var libroBuscado = sc.nextLine();
        libroBuscado = libroBuscado.replace(" ", "%20");
        String URLBusqueda = URL_BASE + libroBuscado;
        json = consumoApi.obtenerDatos(URLBusqueda);
    }

    private void listarLibrosPorIdioma() {
    }

    private void listarAutoresVivosEnUnDeterminadoAnio() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarLibrosRegistrados() {
    }

    private void buscarLibroPorTitulo() {
        getDatosBusquedaAPI();
        DatosBusqueda datos = conversor.obtenerDatos(json, DatosBusqueda.class);

        if (!datos.librosEncontrados().isEmpty()) { // Si se encontraron libros
            System.out.println("Datos del primer libro encontrado: ");
            System.out.println("Título: " + datos.librosEncontrados().get(0).getTitulo());
           // traer los datos del autor
            System.out.println("Idioma: " + datos.librosEncontrados().get(0).getIdioma());
            System.out.println("Descargas: " + datos.librosEncontrados().get(0).getNumeroDescargas());
            Optional<String> datosAutor = datos.librosEncontrados().get(0).autores().stream()
                    .map(DatosAutor::autor)
                    .findFirst();
            // muestro el listado de autores
            System.out.println("Autor: " + datosAutor.get());

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

            repository.save(libro); // Guardar el libro y sus autores en la base de datos
        } else { // Si no se encontraron libros
            System.out.println("No se encontraron libros con el título buscado.");
        }
    }
}
