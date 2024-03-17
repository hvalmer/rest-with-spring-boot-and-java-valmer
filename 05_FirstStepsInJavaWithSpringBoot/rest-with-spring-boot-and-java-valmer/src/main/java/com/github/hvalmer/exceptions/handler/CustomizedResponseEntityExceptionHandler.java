package com.github.hvalmer.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.hvalmer.exceptions.ExceptionResponse;
import com.github.hvalmer.exceptions.UnsupportedOperaException;

@ControllerAdvice //juntar os tratamentos de todos os controllers
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	//metodo que trata as exceçoes mais generica
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request) {
		//retornando a exceção customizada
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	} 
	
	//metodo para tratar exception mais especifica
	@ExceptionHandler(UnsupportedOperaException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request) {
		//retornando a exceção customizada
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	} 
}
