package com.clinicamedica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionBase extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceptionBase(String exception) {
		super(exception);
	}
}
