package com.jtc.exception;

import java.util.Map;

import org.modelmapper.builder.MapExpression;

public class ValidationException extends RuntimeException {

	private Map<String,Object> error;

	public ValidationException(Map<String, Object> error) {
		super("Validaton Failed");
		this.error = error;
	}

	public Map<String, Object> getError() {
		return error;
	}

	public void setError(Map<String, Object> error) {
		this.error = error;
	}
	
	
	


}
