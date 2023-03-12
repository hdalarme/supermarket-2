package xyz.helbertt.supermarket.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface AuthService {

	ResponseEntity<Boolean> login(@RequestParam String email, @RequestParam String password) throws SupermarketNotFoundException;
	
}
