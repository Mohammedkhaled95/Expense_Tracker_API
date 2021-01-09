
package com.khaled.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class UserExceptionHandling {

	
	

	@ExceptionHandler
	public ResponseEntity<MyErrorResponse> handleException (UserException ex){
		MyErrorResponse error =new MyErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler
	public ResponseEntity<MyErrorResponse> handleException (HttpClientErrorException  ex){
		
		
		MyErrorResponse error =new MyErrorResponse();
		
		error.setStatus(HttpStatus.OK.value());
		error.setMessage("momo "+ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
	
}
