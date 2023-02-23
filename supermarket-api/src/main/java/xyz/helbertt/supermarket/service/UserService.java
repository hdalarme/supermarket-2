package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;

public interface UserService {

	List<User> getAll();
	
	User create(User user);
	
	User update(Long id, User user) throws SupermarketNotFoundException;
	
	void delete(Long id) throws SupermarketNotFoundException;
	
	User getById(Long id) throws SupermarketNotFoundException;
	
}