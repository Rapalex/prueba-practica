package com.example.practica.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.practica.model.Response;
import com.example.practica.service.GreetAndFactorialServiceImpl;

@SpringBootTest
class GreetAndFactorialControllerTest {
	
	@Autowired
	GreetAndFactorialController greetAndFactorialController;
	
	@Test
	void getFactorial() {
		Map<String, String> values = new HashMap<>();
		values.put("Resultado factorial", "5040");
		values.put("Valor enviado", "7");
		Response response = new Response(values);
		GreetAndFactorialServiceImpl greetAndFactorialServiceImpl = mock(GreetAndFactorialServiceImpl.class);
		when(greetAndFactorialServiceImpl.calculateFactorial(7)).thenReturn(response);
		
		ResponseEntity<Object> responseEntity = greetAndFactorialController.getFactorial(7);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("5040", ((Response)responseEntity.getBody()).values.get("Resultado factorial").toString());
		
	}
	
	@Test
	void getGreeting() {
		ResponseEntity<Object> responseEntity = greetAndFactorialController.getGreeting();

		assertEquals("Hola, te damos la bienvenida al curso de desarrollo de java con el equipo Codificate con Edi", ((Response)responseEntity.getBody()).values.get("Saludo").toString());
	}

}
