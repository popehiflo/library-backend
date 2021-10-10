package pe.popehiflo.librarybackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.popehiflo.librarybackend.model.Categoria;
import pe.popehiflo.librarybackend.repository.CategoriaRepository;
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
}