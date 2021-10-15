package pe.popehiflo.librarybackend.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.popehiflo.librarybackend.dto.CategoriaDTO;
import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.service.CategoriaService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	/**
	 * GET Categoria por id
	 * @param id
	 * @return objeto Categoria con su lista de Libros
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable("id") Integer id) {
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	// DTO que listara las CATEGORIAS omitiendo los LIBROS que hay en ellas
	/**
	 * GET Lista de Categorias
	 * @return lista de CATEGORIAS sin sus LIBROS
	 */
	@GetMapping(value = "")
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(
				cat -> new CategoriaDTO(cat)).collect(Collectors.toList()
		);
		return ResponseEntity.ok().body(listDTO);
	}
	
	/**
	 * POST create Categoria
	 * @param objCategoria objeto enviado en la request
	 * @return nada, no construye el body
	 */
	@PostMapping(value = "")
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria objCategoria) {
		objCategoria = service.create(objCategoria);
		/* URL de acceso a la nueva clase/objeto creado
		 * el URL aparecera en los HEADERS exactamente en LOCATION */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		
		/* retornar el obejto creado en el body del request */
		//return ResponseEntity.created(uri).body(objCategoria);
		
		/* NO retornar el objeto creado en el body del request
		 * porque con build no se construye el body */
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoriaDTO objCategoriaDto) {
		Categoria newObj = service.update(id, objCategoriaDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
