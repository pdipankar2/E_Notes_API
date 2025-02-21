package com.jtc.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handelException(Exception e){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handelNullPointerException(Exception e){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handelResourceNotFoundException(Exception e){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handelValidationExcepton(ValidationException e){
		
		return new ResponseEntity<>(e.getError(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ExistDataException.class)
	public ResponseEntity<?> handelExistDataException(ExistDataException e){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
	}

}
