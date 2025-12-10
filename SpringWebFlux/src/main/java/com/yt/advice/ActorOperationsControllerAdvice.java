package com.yt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActorOperationsControllerAdvice 
{

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException re)
	{
		
		return new ResponseEntity<String>("Internal Problem Error"+re.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception e)
	{
		return new ResponseEntity<String>("Intenal Problem "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
