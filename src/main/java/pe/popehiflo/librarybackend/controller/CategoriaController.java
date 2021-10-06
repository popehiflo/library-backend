package pe.popehiflo.librarybackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.service.CategoriaService;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable("id") Integer id) {
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
}
