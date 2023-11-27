package com.example.practica.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.exception.RequestException;
import com.example.practica.model.Client;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("client")
public class ClientController {

	@PostMapping
	public ResponseEntity<Object> getClient(@Valid @RequestBody Client client) throws JsonSyntaxException, IOException {
			ClassLoader classLoader = getClass().getClassLoader();

			Client clientC = new Gson().fromJson(
					IOUtils.toString(classLoader.getResource("mocks/client.json"), StandardCharsets.UTF_8),
					Client.class);

			if (client.getId().equals(clientC.getId())) {
				return new ResponseEntity<>(clientC, HttpStatus.OK);
			} else {
				throw new RequestException("004" , "El cliente consultado no se encuentra en la base de datos");
			}
	}

}
