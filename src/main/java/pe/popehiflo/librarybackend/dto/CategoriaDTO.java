package pe.popehiflo.librarybackend.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import pe.popehiflo.librarybackend.model.Categoria;

import javax.validation.constraints.NotEmpty;

// Permitira listar CATEGORIAS pero sin sus LIBROS
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo NOMBRE es requerido")
	@Length(min = 3, max = 100, message = "Campo NOMBRE debe tener entre 3 y 100 caracteres")
	private String nombre;
	@NotEmpty(message = "Campo DESCRIPCION es requerido")
	@Length(min = 3, max = 200, message = "Campo DESCRIPCION debe tener entre 3 y 200 caracteres")
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
