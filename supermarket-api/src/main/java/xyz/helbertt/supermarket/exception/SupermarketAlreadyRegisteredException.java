package xyz.helbertt.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SupermarketAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1906062962869833842L;

	public SupermarketAlreadyRegisteredException(String model, String email) {
		super(String.format("E-mail %s is already registered in the system for another %s.", email, model));
	}
	
	public SupermarketAlreadyRegisteredException(String model, String field, String value) {
		super(String.format("%s %S is already registered in the system for another %s.", field, value, model));
	}
	
}
