package xyz.helbertt.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SupermarketNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1906062962869833842L;

	public SupermarketNotFoundException(String model, Long id) {
		super(String.format(" %s with id %s not found in the system. ", model, id));
	}
	
	public SupermarketNotFoundException(String model, String field, String codigoBarra) {
		super(String.format(" %s with %s %s not found in the system. ", model, field, codigoBarra));
	}
	
}
