package com.educandoweb.course.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("ID '" + id + "' não foi encontrado!");
	}
}
