package com.asset.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.asset.entity.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> NotFoundException(NotFoundException ide, WebRequest request)
	{
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, ide.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorMessage> NoDataException(BadRequestException ide, WebRequest request)
	{
		ErrorMessage message=new ErrorMessage(HttpStatus.BAD_REQUEST, ide.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		
	}

}
