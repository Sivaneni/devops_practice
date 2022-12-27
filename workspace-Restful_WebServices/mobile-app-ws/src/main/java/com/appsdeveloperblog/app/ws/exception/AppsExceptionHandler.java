package com.appsdeveloperblog.app.ws.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({Exception.class,UserServiceException.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		
		 Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp",
		  LocalDateTime.now()); body.put("message", ex.getMessage().toString());
		 
		System.out.println("in exception class");
		return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

}
