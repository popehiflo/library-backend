package pe.popehiflo.librarybackend.dto;

import pe.popehiflo.librarybackend.model.Libro;

import java.io.Serializable;

/**
 * DTO para mostrar solo id, titulo del Libro
 */
public class LibroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LibroDTO() {
        super();
    }

    public LibroDTO(Libro libroRecibido) {
        super();
        this.id = libroRecibido.getId();
        this.titulo = libroRecibido.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
