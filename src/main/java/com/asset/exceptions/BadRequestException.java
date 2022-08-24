package com.asset.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadRequestException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	 public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BadRequestException(String message) {
	super(message);
	}
	public BadRequestException(String message, Throwable cause) {
	super(message, cause);
	}
	public BadRequestException(Throwable cause) {
	super(cause);
	}



}
