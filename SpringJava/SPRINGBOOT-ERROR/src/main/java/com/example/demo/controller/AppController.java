package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Error;

@RestController
public class AppController {
	
	
	@GetMapping({"/","/index"})
	public String index () {
		int value = 2000/0;
		return"error 200 , hola.";
	}
	
	@GetMapping("/usuario")
	public Map<String, String> datosUsuario(){
		Map<String,String> usuario1 = new HashMap<>();
		usuario1.put("nombre", "Kevin Oblitas");
		usuario1.put("deporte", "futbol");
		return usuario1;
	}
	
	@GetMapping("/ArregloDTOerror")
	public List<Error> Error(){
		Error error = new Error();
		error.setDate(new Date());
		error.setMessage("Hola error desde el controler y DTO error" );
		error.setError("Error de division por cero!!!");
		error.setStatus(500);
		
		List<Error> errorList = new ArrayList<>();
		errorList.add(error);
		
		return errorList;
	}
}
