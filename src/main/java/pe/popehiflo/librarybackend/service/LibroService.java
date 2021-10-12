package pe.popehiflo.librarybackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.repository.LibroRepository;
import pe.popehiflo.librarybackend.service.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Libro findById(Integer id) {
        Optional<Libro> resp = repository .findById(id);
        return resp.orElseThrow(() -> new ObjectNotFoundException(
                "¡Libro no encontrado! ID: " + id + ", TIPO: " + Libro.class.getName()
        ));
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    /**
     * Lista Libros que pertenecen a una Categoria especifica
     * @param idCategoria
     * @return lista Libros
     */
    public List<Libro> findAll(Integer idCategoria) {
        categoriaService.findById(idCategoria);
        return repository.findAllByCategoria(idCategoria);
    }

    public Libro update(Integer id, Libro newLibro) {
        Libro oldLibro = findById(id);
        updateData(oldLibro, newLibro);
        return  repository.save(oldLibro);
    }

    private void updateData(Libro oldLibro, Libro newLibro) {
        oldLibro.setTitulo(newLibro.getTitulo());
        oldLibro.setNombreAutor(newLibro.getNombreAutor());
        oldLibro.setTexto(newLibro.getTexto());
    }
}
