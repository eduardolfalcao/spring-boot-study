package br.com.edufalcao.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.edufalcao.exception.ExceptionResponse;
import br.com.edufalcao.exception.InvalidJwtAuthenticationException;
import br.com.edufalcao.exception.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException ex, WebRequest request) {	 
	    ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
	    return new ResponseEntity<ExceptionResponse>(
	      exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {	 
	    ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
	    return new ResponseEntity<ExceptionResponse>(
	      exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ InvalidJwtAuthenticationException.class })
	public ResponseEntity<ExceptionResponse> invalidJwtAuthenticationException(Exception ex, WebRequest request) {	 
	    ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
	    return new ResponseEntity<ExceptionResponse>(
	      exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}


