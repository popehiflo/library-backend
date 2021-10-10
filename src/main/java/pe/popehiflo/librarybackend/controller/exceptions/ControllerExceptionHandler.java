package pe.popehiflo.librarybackend.controller.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.popehiflo.librarybackend.service.exceptions.ObjectNotFoundException;

@ControllerAdvice // anotacion que manejara/capturara todas las excepciones de la aplicacion
public class ControllerExceptionHandler {
	
	//HttpServletRequest para obtener el path /categorias/1
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
	
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
