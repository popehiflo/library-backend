package pe.popehiflo.librarybackend.dto;

import java.io.Serializable;

import pe.popehiflo.librarybackend.model.Categoria;

// Permitira listar CATEGORIAS pero sin sus LIBROS
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaDTO(Categoria categoriaRecibida) {
		super();
		this.id = categoriaRecibida.getId();
		this.nombre = categoriaRecibida.getNombre();
		this.descripcion = categoriaRecibida.getDescripcion();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
