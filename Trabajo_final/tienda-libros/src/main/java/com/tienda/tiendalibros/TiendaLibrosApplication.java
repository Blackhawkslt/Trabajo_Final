package com.tienda.tiendalibros;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tienda.model.Libro;
import com.tienda.repository.LibroRepository;
@ComponentScan(basePackages = "com.tienda.config")
@SpringBootApplication
@EntityScan("com.tienda.model")
@EnableJpaRepositories("com.tienda.repository")
public class TiendaLibrosApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(TiendaLibrosApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        Libro libro1 = new Libro("100 años de soledad", "Gabriel Garcia Marquez", 20000.0);
        Libro libro2 = new Libro("Los Hermanos Karamazov", "Fiodor Dostoievski", 25000.0);
		Libro libro3 = new Libro("Rayuela", "Julio Cortazar", 60000.0);
        libroRepository.saveAll(Arrays.asList(libro1, libro2, libro3));
    }
}
