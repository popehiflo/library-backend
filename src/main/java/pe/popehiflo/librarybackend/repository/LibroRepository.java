package pe.popehiflo.librarybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.popehiflo.librarybackend.model.Libro;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

    @Query("SELECT obj FROM Libro obj WHERE obj.categoria.id=:idCategoria ORDER BY obj.titulo")
    List<Libro> findAllByCategoria(@Param(value = "idCategoria") Integer idCategoria);
}
