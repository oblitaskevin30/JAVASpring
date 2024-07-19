package com.example.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.model.Error;


@RestControllerAdvice
public class ErrorHandlerController {
	
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Error> divisionByZero(Exception e){
		Error error = new Error();
		error.setDate(new Date());
		error.setMessage("Hola error desde el controler y DTO error" + e.getLocalizedMessage());
		error.setError("Error de division por cero!!!");
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(error);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Error> nullEception(Exception e){
		Error error = new Error();
		error.setDate(new Date());
		error.setMessage("el rol del usuario no existe " + e.getLocalizedMessage());
		error.setError("Error de nulo : NullPointerException");
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(error);
	}
}
