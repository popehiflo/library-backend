package pe.popehiflo.librarybackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.popehiflo.librarybackend.dto.CategoriaDTO;
import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.service.CategoriaService;

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
}
