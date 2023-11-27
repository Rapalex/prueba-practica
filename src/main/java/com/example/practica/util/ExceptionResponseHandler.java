package com.example.practica.util;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.practica.exception.RequestException;
import com.google.gson.JsonSyntaxException;

/**
 * Clase encargada de manejar las excepciones identificadas del aplicativo
 */
@ControllerAdvice
public class ExceptionResponseHandler {

	/**
	 * Metodo para manejar el código de error 400
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { IllegalStateException.class, HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> validationException(Exception ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<>(new ExceptionResponseDTO("001", "Error en los datos ingresados, revisarlos e intentar de nuevo", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Metodo para manejar el código de error 500
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { NullPointerException.class, JsonSyntaxException.class, IOException.class, ArithmeticException.class })
	public ResponseEntity<Object> internalException(Exception ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<>(new ExceptionResponseDTO("002", "Estamos presentando fallas, por favor intentar de nuevo más tarde.", LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Metodo para manejar el código de error 404
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { NoHandlerFoundException.class })
	public ResponseEntity<Object> notFoundException(NoHandlerFoundException ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<>(new ExceptionResponseDTO("003", "El recurso solicitado no se encuentra disponible", LocalDateTime.now()), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Metodo para manejar la custom exception creada llamada RequestException
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { RequestException.class })
	public ResponseEntity<Object> notFoundException(RequestException ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<>(new ExceptionResponseDTO(ex.getCode(), ex.getMessage(), LocalDateTime.now()), HttpStatus.OK);
	}
}
