package com.example.practica.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Client {

	@NotNull(message = "El documento no debe ser nulo")
	@NotEmpty(message = "El documento no debe estar vacío")
	@JsonProperty("documento")
	private String id;
	
	@NotNull(message = "El tipo de documento no debe estar vacío")
	@JsonProperty("tipoDocumento")
	private idType idType;
	
	@JsonProperty("primerNombre")
	private String firstName;

	@JsonProperty("segundoNombre")
	private String secondName;

	@JsonProperty("primetApellido")
	private String firstSurname;

	@JsonProperty("segundoApellido")
	private String secondSurname;

	@JsonProperty("telefono")
	private String phone;

	@JsonProperty("direccion")
	private String address;

	@JsonProperty("ciudad")
	private String city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
