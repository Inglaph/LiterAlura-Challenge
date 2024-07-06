package com.literalura.literalura.principal;

import com.literalura.literalura.model.Autor;
import com.literalura.literalura.model.DatosAutor;
import com.literalura.literalura.model.DatosBusqueda;
import com.literalura.literalura.model.Libro;
import com.literalura.literalura.service.ConsumoAPI;
import com.literalura.literalura.service.ConvierteDatos;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private String json = "";
    ConvierteDatos conversor = new ConvierteDatos();
    private static int opcionMenu = 6;


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


    private void listarLibrosPorIdioma() {
    }

    private void listarAutoresVivosEnUnDeterminadoAnio() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarLibrosRegistrados() {
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        String libroBuscado = sc.nextLine();
        libroBuscado = libroBuscado.replace(" ", "%20");
        String URLBusqueda = URL_BASE + libroBuscado;
        json = consumoApi.obtenerDatos(URLBusqueda);
        // System.out.println(json);

        //  Convertir el JSON a un objeto de la clase DatosLibro
        DatosBusqueda datos = conversor.obtenerDatos(json, DatosBusqueda.class);
        //System.out.println(datos);

        // Mostrar los datos del libro encontrado en primer lugar
        System.out.println("Datos del primer libro encontrado: ");
        System.out.println("Título: " + datos.librosEncontrados().get(0).getTitulo());
        System.out.println("Autor: " + datos.librosEncontrados().get(0).getAutores().get(0));
        System.out.println("Idioma: " + datos.librosEncontrados().get(0).getIdioma());
        System.out.println("Descargas: " + datos.librosEncontrados().get(0).getNumeroDescargas());

        // Convertimos el objeto DatosLibro a un objeto de la clase Libro
        System.out.println("\nDatos del libro convertido a la clase Libro para guardar en BD: ");
        Libro libro = new Libro(datos.librosEncontrados().get(0));
        System.out.println(libro);
        var autores = libro.getAutores();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        int contador = 1;
        System.out.println("Autores del libro: ");
        for (Autor autor : autores) {
            System.out.println(contador + ". " + autor.getAutor() + " - " +
                    autor.getAnoNacimiento().format(formatter) + " - " + autor.getAnoFallecimiento().format(formatter));
            contador++;
        }
        System.out.println("************************************");

    }
}
