package com.yt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yt.exception.TuristNotFoundException;
import com.yt.model.ErrorDetails;

@RestControllerAdvice
public class TuristErrorHandler 
{
	
	@ExceptionHandler(TuristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTuristNotFoundException(TuristNotFoundException tnf)
	{
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),tnf.getMessage()
,"404 turist not found");
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception e)
	{
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in execution");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
