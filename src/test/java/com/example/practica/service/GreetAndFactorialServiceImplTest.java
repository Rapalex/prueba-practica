package com.example.practica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.practica.model.Response;

@SpringBootTest
class GreetAndFactorialServiceImplTest {
	
	@Autowired
	GreetAndFactorialServiceImpl greetAndFactorialServiceImpl;

	@Test
	void calculateFactorialTest() {
		Response response = greetAndFactorialServiceImpl.calculateFactorial(7);
		assertEquals(5040, Integer.parseInt(response.values.get("Resultado factorial")));
		assertEquals(7, Integer.parseInt(response.values.get("Valor enviado")));
	}

}
