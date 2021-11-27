package com.shashi.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shashi.practice.entity.Student;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotfoundException extends RuntimeException {
	
	String message;
	
	private static final long serialVersionUID = 1L;
	

	public NotfoundException(String message) {
		super(message);
	}
	
	}

    

