package pe.popehiflo.librarybackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.repository.LibroRepository;
import pe.popehiflo.librarybackend.service.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public Libro findById(Integer id) {
        Optional<Libro> resp = repository .findById(id);
        return resp.orElseThrow(() -> new ObjectNotFoundException(
                "¡Libro no encontrado! ID: " + id + ", TIPO: " + Libro.class.getName()
        ));
    }
}
