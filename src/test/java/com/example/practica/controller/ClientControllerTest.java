package com.example.practica.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.practica.exception.RequestException;
import com.example.practica.model.Client;
import com.google.gson.JsonSyntaxException;

@SpringBootTest
class ClientControllerTest {
	
	@Autowired
	ClientController clientController;

	@Test
	void testSetClientNotFound() throws JsonSyntaxException, IOException {
		Client client = new Client();
		client.setId("1037");
		
		assertThrows(RequestException.class, () -> {
			clientController.getClient(client);
		});
	}
	
	@Test
	void testSetClientOk() throws JsonSyntaxException, IOException {
		Client client = new Client();
		client.setId("23445322");
		ResponseEntity<Object> responseEntity = clientController.getClient(client);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
