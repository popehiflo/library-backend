package pe.popehiflo.librarybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.popehiflo.librarybackend.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
