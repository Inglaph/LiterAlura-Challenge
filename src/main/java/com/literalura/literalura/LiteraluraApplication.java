package com.literalura.literalura;

import com.literalura.literalura.model.DatosBusqueda;
import com.literalura.literalura.principal.Principal;
import com.literalura.literalura.repository.LibroRepository;
import com.literalura.literalura.service.ConsumoAPI;
import com.literalura.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ajusta este comando SQL según tu base de datos
		String sql = "ALTER SEQUENCE autores_id_seq RESTART WITH 18;";
		jdbcTemplate.execute(sql);
		Principal principal = new Principal(libroRepository);
		principal.mostrarMenu();

	}
}