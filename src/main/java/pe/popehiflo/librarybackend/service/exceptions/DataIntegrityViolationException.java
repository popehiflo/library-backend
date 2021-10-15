package pe.popehiflo.librarybackend.service.exceptions;

/**
 * Exception para DataIntegrity, cuando quieres eliminar objeto
 * que tiene otros relacionados; ej. Categoria que posee Libros relacionados
 */
public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
