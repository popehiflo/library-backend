package pe.popehiflo.librarybackend.controller.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.popehiflo.librarybackend.service.exceptions.DataIntegrityViolationException;
import pe.popehiflo.librarybackend.service.exceptions.ObjectNotFoundException;

@ControllerAdvice // anotacion que manejara/capturara todas las excepciones de la aplicacion
public class ControllerExceptionHandler {
	
	//HttpServletRequest para obtener el path /categorias/1
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	/**
	 * Cuando no pasa la Validación de Entidad (ej. @NotBlank, @Length)
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, ServletRequest request) {
		ValidationError error = new ValidationError(
				System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(),
				"Error en validación de campos"
		);
		for (FieldError field: e.getBindingResult().getFieldErrors()) {
			error.addErrors(field.getField(), field.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
