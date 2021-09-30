package pe.popehiflo.librarybackend.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.repository.CategoriaRepository;
import pe.popehiflo.librarybackend.repository.LibroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LibroRepository libroRepository;

	// Instanciar BD
	public void instanciarBaseDeDatos() {
		
		Categoria cat01 = new Categoria(null, "Informatica", "Libros de Informatica");
		Categoria cat02 = new Categoria(null, "Infantil", "Libros infantiles");
		Categoria cat03 = new Categoria(null, "Matematica", "Libros de matematica");

		Libro lib01 = new Libro(null, "Clean Code", "Robert Martin", "Libro Clean Code ... texto!", cat01);
		Libro lib02 = new Libro(null, "Spring Boot in Action", "Craig Walls", "Spring Boot in Action is a developer-focused guide to writing applications using Spring Boot", cat01);
		Libro lib03 = new Libro(null, "Constructions Animals", "Emilia Dziubak", "Texto de prueba creado para Constructions Animals", cat02);
		Libro lib04 = new Libro(null, "El libro de los juegos", "Juan Berrio", "Texto de prueba creado para El libro de los juegos", cat02);
		Libro lib05 = new Libro(null, "El equipo de Dingo", "Romina Naranjo", "Texto de prueba creado para El equipo de Dingo", cat02);

		cat01.getLibros().addAll(Arrays.asList(lib01));

		categoriaRepository.saveAll(Arrays.asList(cat01, cat02, cat03));
		libroRepository.saveAll(Arrays.asList(lib01, lib02, lib03, lib04, lib05));
	}
}
