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
  ![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/30949079-a457-45fc-8aea-dd35aeb0717b)


- **Búsqueda de libros por título:** Utiliza la API de Gutendex para buscar libros por título.
![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/e383f918-1211-4dcf-bc8b-ded01290ed11)


- **Listado de libros registrados:** Muestra todos los libros que están registrados en la base de datos local.
![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/87c8ec98-6ae9-4a35-957a-846cb7eee11d)


- 
- **Listado de autores registrados:** Muestra todos los autores que están registrados en la base de datos local.
![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/f82183e6-6679-4a87-be78-e56078997c27)

- 
- **Listado de autores vivos en un año específico:** Permite listar autores que estaban vivos en un año específico, basado en la información de la base de datos.
![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/1a0d6d21-ebb9-4185-8b6c-9fbabcfa08b3)

- **Listado de libros por idioma:** Permite listar libros registrados en la base de datos filtrados por idioma.
 ![image](https://github.com/Inglaph/LiterAlura-Challenge/assets/86210091/44e9d46c-0a43-445b-a87c-68c814c6c2a5)

- 

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
