package com.cjc.loanapplication.exceptions;

import java.util.Date;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ConfigDataResourceNotFoundException.class)
public ResponseEntity<APIError>NoResourceFoundException(NoResourceFoundException excep,HttpServletRequest req)
{
	APIError error=new APIError();
	error.setStatuscode(HttpStatus.NOT_FOUND.value());
	error.setMessage(excep.getMessage());
	error.setDate(new Date());
	error.setPath(req.getRequestURI());
	error.setHttpmessage(HttpStatus.NOT_FOUND);
	return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	
}
	
}
