package xyz.helbertt.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SupermarketNotFoundException extends Exception {

	public SupermarketNotFoundException(String model, Long id) {
		super(String.format(" %s with id %s not found in the system. ", model, id));
	}
	
}
