package pe.popehiflo.librarybackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.popehiflo.librarybackend.dto.LibroDTO;
import pe.popehiflo.librarybackend.model.Libro;
import pe.popehiflo.librarybackend.service.LibroService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
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

    /**
     * localhost:8080/libros?categoria=1
     * GET Libros que pertenecen a una Categoria determinada por id
     * @param idCategoria, id de la Categoria de la quieres los Libros
     * @return lista de LIBROS (id,titulo) que tiene relacion con la Categoria
     */
    @GetMapping(value = "")
    public ResponseEntity<List<LibroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria) {
        List<Libro> list = service.findAll(idCategoria);
        List<LibroDTO> listDTO = list.stream().map(
                libro -> new LibroDTO(libro)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /**
     * POST create, crea un Libro con la Categoria a la pertenece
     * @param idCategoria - Categoria la que pertenecera el Libro
     * @param objLibro - Objeto Libro con datos a persistir
     * @return no retorna body
     */
    @PostMapping
    public ResponseEntity<Libro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria,
                                        @Valid @RequestBody Libro objLibro) {
        Libro newLibro = service.create(idCategoria, objLibro);
        /* URL de acceso a la nueva clase/objeto creado
         * el URL aparecera en los HEADERS exactamente en LOCATION */
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/libros/{id}").buildAndExpand(newLibro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * PUT update, actualizar todos los valores del objeto Libro
     * @param id
     * @param newLibro
     * @return Libro actualizado
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Libro> update(@PathVariable("id") Integer id, @Valid @RequestBody Libro newLibro) {
        Libro updatedLibro = service.update(id, newLibro);
        return ResponseEntity.ok().body(updatedLibro);
    }

    /**
     * PATCH updatePatch, actualizar un valor del objeto Libro
     * @param id
     * @param newLibro
     * @return Libro actualizado
     */
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Libro> updatePatch(@Valid @PathVariable("id") Integer id, @Valid @RequestBody Libro newLibro) {
        Libro updatedLibro = service.update(id, newLibro);
        return ResponseEntity.ok().body(updatedLibro);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
