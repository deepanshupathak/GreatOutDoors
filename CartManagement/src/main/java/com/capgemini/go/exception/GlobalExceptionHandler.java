package com.capgemini.go.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@ResponseStatus(HttpStatus.NOT_FOUND)  
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  
	  @ExceptionHandler(Exception.class) public ResponseEntity<?>
	  handleGlobalException(Exception exception,WebRequest request) { ErrorDetails
	  errorDetails=new ErrorDetails(new
	  Date(),"invaild request",request.getDescription(false)); 
	  return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST); }
	 
}
