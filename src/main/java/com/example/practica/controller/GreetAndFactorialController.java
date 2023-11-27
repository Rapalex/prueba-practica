package com.example.practica.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.model.Response;
import com.example.practica.service.GreetAndFactorialServiceImpl;
import com.example.practica.util.Properties;

@RestController
@RequestMapping("api")
public class GreetAndFactorialController {
	
	@Autowired
	private GreetAndFactorialServiceImpl greetAndFactorialServiceImpl;
	
	@GetMapping(value = "/factorial/{number}")	
	public ResponseEntity<Object> getFactorial(@PathVariable int number){
		return new ResponseEntity<>(greetAndFactorialServiceImpl.calculateFactorial(number) ,  HttpStatus.OK);
	}
	
	@GetMapping(value = "/hola")	
	public ResponseEntity<Object> getGreeting(){
		Map<String, String> values = new HashMap<>();
		values.put("Saludo", Properties.GREETING_MESSAGE + " " + Properties.DEVELOPMENT_TEAM);
		return new ResponseEntity<>(new Response(values) ,  HttpStatus.OK);
	}
}
