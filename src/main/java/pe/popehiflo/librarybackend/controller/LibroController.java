package pe.popehiflo.librarybackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.service.LibroService;

@RestController
@RequestMapping(value = "libros")
public class LibroController {

    @Autowired
    private LibroService service;

    /**
     * GET Libro por id
     * @param id, id del Libro a buscar
     * @return objeto Libro
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Libro> findById(@PathVariable("id") Integer id) {
        Libro libro = service.findById(id);
        return ResponseEntity.ok().body(libro);
    }
}
