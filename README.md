# LiterAlura-Challenge
Desarrollo del desafio para especializacion BackEnd - Oracle ONE Next Education G6

by [*@inglaph*](https://github.com/Inglaph)
*2024*
# Literalura Application

by [*@inglaph*](https://github.com/Inglaph)
**Oracle ONE Next Education G6**  
*2024*

___
## Tabla de Contenido

- [Literalura Application](#literalura-application)
  - [Tabla de Contenido](#tabla-de-contenido)
  - [Descripción](#descripción)
  - [Funcionalidades](#funcionalidades)
  - [Validaciones](#validaciones)
  - [Tecnologías y Herramientas](#tecnologías-y-herramientas)
  - [Licencia](#licencia)

## Descripción
Literalura es una aplicación diseñada para facilitar la búsqueda y gestión de libros y autores. Permite a los usuarios buscar libros por título a través de una API externa, listar libros y autores registrados en la base de datos, listar autores vivos en un año específico, y listar libros por idioma.

## Funcionalidades
- **Menu principal:** Cuenta con el siguiente menu.
  ![Menu](image.png)


- **Búsqueda de libros por título:** Utiliza la API de Gutendex para buscar libros por título.
 


- **Listado de libros registrados:** Muestra todos los libros que están registrados en la base de datos local.

- 
- **Listado de autores registrados:** Muestra todos los autores que están registrados en la base de datos local.

- 
- **Listado de autores vivos en un año específico:** Permite listar autores que estaban vivos en un año específico, basado en la información de la base de datos.

- **Listado de libros por idioma:** Permite listar libros registrados en la base de datos filtrados por idioma.


## Validaciones
- **No guarda el mismo libro dos veces en la BD:**
- **Valida datos completos:** Los datos de Titulo libro, Autor (Fecha nacimiento y fallecimiento) deben estar completos para poder guardar el registro.



## Tecnologías y Herramientas
- **Java:** Lenguaje de programación utilizado para desarrollar la aplicación.
- **Spring Boot:** Marco de trabajo utilizado para simplificar el proceso de configuración y publicación de la aplicación.
- **Maven:** Herramienta de gestión y comprensión de proyectos de software.
- **JPA (Java Persistence API):** Utilizado para la gestión de la persistencia de datos en la base de datos.
- **PostgreSQL:** Base de datos utilizada para el desarrollo y pruebas.
- **IntelliJ IDEA:** Entorno de desarrollo integrado (IDE) utilizado para el desarrollo de la aplicación.


## Licencia
Este proyecto está licenciado bajo la Licencia MIT - vea el archivo `LICENSE.md` para más detalles.