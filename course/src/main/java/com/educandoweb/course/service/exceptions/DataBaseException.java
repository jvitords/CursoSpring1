package com.educandoweb.course.service.exceptions;

public class DataBaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataBaseException(String mensagemException) {
		super(mensagemException);
	}
}
