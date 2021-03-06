package pe.popehiflo.librarybackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.popehiflo.librarybackend.dto.CategoriaDTO;
import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.repository.CategoriaRepository;
import pe.popehiflo.librarybackend.service.exceptions.DataIntegrityViolationException;
import pe.popehiflo.librarybackend.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> resp = repository.findById(id);
		return resp.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto no fue encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()
				)
		);
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	
	public Categoria create(Categoria objCategoria) {
		objCategoria.setId(null);
		return repository.save(objCategoria);
	}
	
	public Categoria update(Integer id, CategoriaDTO objCategoriaDto) {
		Categoria obj = findById(id);
		obj.setNombre(objCategoriaDto.getNombre());
		obj.setDescripcion(objCategoriaDto.getDescripcion());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Esta Categoria no puede ser borrada! Posee Libros asociados");
		}
	}
}
