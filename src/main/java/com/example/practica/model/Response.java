package com.example.practica.model;

import java.util.Map;

public class Response {
	
	public Map<String, String> values;

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	public Response(Map<String, String> values) {
		this.values = values;
	}

}
