package pe.popehiflo.librarybackend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.repository.CategoriaRepository;
import pe.popehiflo.librarybackend.repository.LibroRepository;

@SpringBootApplication
public class LibraryBackendApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat01 = new Categoria(null, "Informatica", "Libros de Informatica");

		Libro lib01 = new Libro(null, "Libro de popehilo", "popehiflo", "Texto de prueba creado por popehiflo", cat01);

		cat01.getLibros().addAll(Arrays.asList(lib01));

		this.categoriaRepository.save(cat01);
		this.libroRepository.save(lib01);
		
	}

}
