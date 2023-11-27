package com.example.practica.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.practica.model.Response;

@Service
public class GreetAndFactorialServiceImpl implements GreetAndFactorialService {

	/**
	 * Calculo de el factorial de un número determinado
	 *@param number número al cual se le va a calcular el factorial
	 */
	@Override
	public Response calculateFactorial(int number) {
		/**
		 * En primera instancia iba a usar esta fórmula con streams de java 8 para hacer
		 * el cálculo pero al realizar pruebas con números mayores a 20 no da el
		 * resultado correcto ya que el tipo de dato long está limitado en su cantidad
		 * de caracteres y no soporta el resultado
		 * 
		 * long result = LongStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
		 * 
		 **/
		
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		Map<String, String> values = new HashMap<>();
		
		values.put("Valor enviado", number+"");
		values.put("Resultado factorial", result+"");
		
		return new Response(values);
	}

}
