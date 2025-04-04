package com.educandoweb.course.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.service.exceptions.DataBaseException;
import com.educandoweb.course.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // anotação para pegar qualquer tipo de exception capturada
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // acontecendo qualquer exception da class "ResourceNotFoundException" chegará aqui, pois essa anotação pega qualquer exception de uma certa class
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
		
		String error = "Resource não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), exception.getMessage(), error, request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(DataBaseException.class) // acontecendo qualquer exception da class "ResourceNotFoundException" chegará aqui, pois essa anotação pega qualquer exception de uma certa class
	public ResponseEntity<StandardError> dataBaseException(DataBaseException exception, HttpServletRequest request){
		
		String error = "Interrompido para não afetar a integridade do banco de dados!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), status.value(), exception.getMessage(), error, request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
}